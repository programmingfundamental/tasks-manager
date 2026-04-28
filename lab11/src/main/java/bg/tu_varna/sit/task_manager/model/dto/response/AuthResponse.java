package bg.tu_varna.sit.task_manager.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/***
 * Добавено в лабораторно упражнение 11
 */
@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String username;
    private long expiresAt;
}
