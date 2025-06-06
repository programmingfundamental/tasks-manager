package bg.tu_varna.sit.task_manager.controller;

import bg.tu_varna.sit.task_manager.exception.ResourceNotFoundException;
import bg.tu_varna.sit.task_manager.model.dto.request.FilterReportDto;
import bg.tu_varna.sit.task_manager.model.dto.request.ReportRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.ReportResponseDto;
import bg.tu_varna.sit.task_manager.model.dto.response.TaskResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/***
 * Добавено в лабораторно упражнение 7
 */
@Validated //Добавено в лабораторно упражнение 8
@RestController
@RequestMapping("/reports")
public class ReportController {
    @PostMapping("/task/{id}")
    public ResponseEntity<ReportResponseDto> create(@PathVariable(name = "id") long taskId, @Valid @RequestBody ReportRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ReportResponseDto());
    }
    @GetMapping("/task/{id}")
    public ResponseEntity<List<ReportResponseDto>> getAllByTask(@PathVariable(name = "id") long taskId) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(taskId, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReportResponseDto> get(@PathVariable Long id) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, ReportResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ReportResponseDto());
    }
    @GetMapping()
    public ResponseEntity<List<ReportResponseDto>> getByWorkTimeInDateInterval(
            @Valid @ModelAttribute FilterReportDto filter //Добавено в лабораторно упражнение 8
    ) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(0, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/task/{id}/max-hours-worked")
    public ResponseEntity<List<ReportResponseDto>> getByTaskWithMaxHoursWorked(@PathVariable(name = "id") long taskId) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(taskId, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ArrayList<>());
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<ReportResponseDto> update(@PathVariable Long id, @Valid @RequestBody ReportRequestDto dto) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, ReportResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ReportResponseDto());
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ReportResponseDto> delete(@PathVariable Long id) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, ReportResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ReportResponseDto());
    }
}
