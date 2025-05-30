package bg.tu_varna.sit.task_manager.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

/***
 * Добавено в лабораторно упражнение 7
 */
@NoArgsConstructor
@Getter
public class ReportRequestDto {
    private String content;
    private LocalTime workTime;
}
