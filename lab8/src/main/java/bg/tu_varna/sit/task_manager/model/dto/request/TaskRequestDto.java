package bg.tu_varna.sit.task_manager.model.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/***
 * Добавено в лабораторно упражнение 7
 */
@NoArgsConstructor
@Getter
public class TaskRequestDto {
    @NotBlank(message = "Резюмето е задължително") //Добавено в лабораторно упражнение 8
    @Size(min = 10, max = 255, message = "Резюмето не може да е повече от 255 символа и по малко от 10") //Добавено в лабораторно упражнение 8
    private String summary;

    @Size(min = 10, max = 2500, message = "Описанието не може да е повече от 2000 символа и по малко от 10") //Добавено в лабораторно упражнение 8
    private String description;

    @NotNull(message = "Крайният срок е задължителен") //Добавено в лабораторно упражнение 8
    @Future(message = "Крайният срок трябва да е в бъдещето") //Добавено в лабораторно упражнение 8
    private LocalDateTime deadline;
}
