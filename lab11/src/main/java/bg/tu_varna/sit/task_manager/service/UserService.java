package bg.tu_varna.sit.task_manager.service;

import bg.tu_varna.sit.task_manager.component.JwtTokenProvider;
import bg.tu_varna.sit.task_manager.model.dto.request.UserRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.UserResponseDto;
import bg.tu_varna.sit.task_manager.model.entity.User;
import bg.tu_varna.sit.task_manager.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.repository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public UserResponseDto register(UserRequestDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = repository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto login(UserRequestDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(), userDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        UserResponseDto dto = new UserResponseDto();
        dto.setUsername(authentication.getName());
        dto.setToken(token);
        return dto;
    }
}
