package bg.tu_varna.sit.task_manager.model.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Добавено в лабораторно упражнение 11
 */
@Setter
@Getter
public class UserRequestDto {
    private String name;
    private String username;
    private String password;
}
