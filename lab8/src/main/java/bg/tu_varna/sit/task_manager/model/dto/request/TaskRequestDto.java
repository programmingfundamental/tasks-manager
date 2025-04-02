package bg.tu_varna.sit.task_manager.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/***
 * Добавено в лабораторно упражнение 7
 */
@NoArgsConstructor
@Getter
public class TaskRequestDto {
    private String summary;
    private String description;
    private LocalDateTime deadline;
}
