package bg.tu_varna.sit.task_manager.model.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Добавено в лабораторно упражнение 11
 */
@Setter
@Getter
public class UserResponseDto {
    private long id;
    private String name;
    private String username;
    private String token;
}
