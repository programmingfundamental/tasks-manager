package bg.tu_varna.sit.task_manager.controller;

import bg.tu_varna.sit.task_manager.component.JwtTokenProvider;
import bg.tu_varna.sit.task_manager.model.dto.request.UserRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.TokenResponseDto;
import bg.tu_varna.sit.task_manager.model.dto.response.UserResponseDto;
import bg.tu_varna.sit.task_manager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Добавено в лабораторно упражнение 11
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthenticationController(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto registerUserDto) {
        return ResponseEntity.ok(userService.register(registerUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> authenticate(@RequestBody UserRequestDto dto) {
        UserResponseDto authenticatedUser = userService.login(dto);

        return ResponseEntity.ok(TokenResponseDto.builder()
                .token(authenticatedUser.getToken())
                .expiresIn(jwtTokenProvider.getExpirationTime())
                .build());
    }
}
