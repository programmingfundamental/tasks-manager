package bg.tu_varna.sit.task_manager.model.dto.response;

import lombok.Builder;
import lombok.Getter;

/**
 * Добавено в лабораторно упражнение 11
 */
@Getter
@Builder
public class TokenResponseDto {
    private String token;
    private long expiresIn;
}
