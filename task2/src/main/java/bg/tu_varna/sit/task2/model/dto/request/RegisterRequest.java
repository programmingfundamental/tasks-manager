package bg.tu_varna.sit.task2.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/***
 * Добавено в лабораторно упражнение 11
 */
@Getter
@Setter
public class RegisterRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
