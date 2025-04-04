package bg.tu_varna.sit.task_manager.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

/***
 * Добавено в лабораторно упражнение 7
 */
@NoArgsConstructor
@Getter
public class ReportRequestDto {
    @NotBlank(message = "Съдържанието не може да бъде празно") //Добавено в лабораторно упражнение 8
    @Size(min = 10, message = "Съдържанието трябва да е поне") //Добавено в лабораторно упражнение 8
    @Size(max = 2500, message = "Съдържанието не може да бъде повече от 2500 символа") //Добавено в лабораторно упражнение 8
    private String content;

    @NotNull(message = "Работното време е задължително") //Добавено в лабораторно упражнение 8
    private LocalTime workTime;
}
