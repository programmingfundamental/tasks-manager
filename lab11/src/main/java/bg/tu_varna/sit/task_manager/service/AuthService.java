package bg.tu_varna.sit.task_manager.service;

import bg.tu_varna.sit.task_manager.model.dto.request.LoginRequest;
import bg.tu_varna.sit.task_manager.model.dto.request.RegisterRequest;
import bg.tu_varna.sit.task_manager.model.dto.response.AuthResponse;
import bg.tu_varna.sit.task_manager.model.entity.RefreshToken;
import bg.tu_varna.sit.task_manager.model.entity.Role;
import bg.tu_varna.sit.task_manager.model.entity.User;
import bg.tu_varna.sit.task_manager.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    public void register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Потребителското име вече съществува");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .enabled(true)
                .build();

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request, HttpServletRequest httpRequest) {
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();

        if (currentAuth != null
                && currentAuth.isAuthenticated()
                && !(currentAuth instanceof AnonymousAuthenticationToken)) {

            String newAccessToken = jwtService.generateAccessToken(currentAuth);
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(currentAuth.getName());

            return new AuthResponse(
                    newAccessToken,
                    refreshToken.getToken(),
                    currentAuth.getName(),
                    jwtService.extractExpiration(newAccessToken).getTime()
            );
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        HttpSession session = httpRequest.getSession(true);
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                context
        );

        String accessToken = jwtService.generateAccessToken(authentication);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(authentication.getName());

        return new AuthResponse(
                accessToken,
                refreshToken.getToken(),
                authentication.getName(),
                jwtService.extractExpiration(accessToken).getTime()
        );
    }

    public AuthResponse refresh(String refreshTokenValue) {
        RefreshToken refreshToken = refreshTokenService.validateRefreshToken(refreshTokenValue);

        User user = userRepository.findByUsername(refreshToken.getUsername())
                .orElseThrow(() -> new RuntimeException("Потребителят не е намерен"));

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                null,
                java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority(user.getRole().name()))
        );

        String newAccessToken = jwtService.generateAccessToken(authentication);

        return new AuthResponse(
                newAccessToken,
                refreshToken.getToken(),
                user.getUsername(),
                jwtService.extractExpiration(newAccessToken).getTime()
        );
    }

    public void logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            refreshTokenService.revokeAllUserTokens(authentication.getName());
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        SecurityContextHolder.clearContext();
    }
}
