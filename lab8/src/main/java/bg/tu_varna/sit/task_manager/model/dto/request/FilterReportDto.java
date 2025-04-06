package bg.tu_varna.sit.task_manager.model.dto.request;

import bg.tu_varna.sit.task_manager.model.validator.AfterMidnight;
import bg.tu_varna.sit.task_manager.model.validator.ValidDateRange;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@ValidDateRange
public class FilterReportDto {
    @NotNull
    @AfterMidnight
    private LocalTime time;

    @NotNull
    @Future(message = "Началната дата трябва да е в бъдещето")
    private LocalDateTime from;

    @NotNull
    @Future(message = "Крайната дата трябва да е в бъдещето")
    private LocalDateTime to;
}
