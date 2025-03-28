package bg.tu_varna.sit.task_manager.controller;

import bg.tu_varna.sit.task_manager.model.dto.request.ReportRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.ReportResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/***
 * Добавено в лабораторно упражнение 7
 */
@RestController
@RequestMapping("/reports")
public class ReportController {
    @PostMapping("/{task-id}")
    public ResponseEntity<List<ReportResponseDto>> create(@PathVariable(name = "task-id") long taskId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{task-id}")
    public ResponseEntity<List<ReportResponseDto>> getAllByTask(@PathVariable(name = "task-id") long taskId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReportResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(new ReportResponseDto());
    }
    @GetMapping()
    public ResponseEntity<List<ReportResponseDto>> getByHoursWorkedFromDateCreatedToDateUpdated(@RequestParam Long hoursWorked, @RequestParam LocalDateTime dateCreated, @RequestParam LocalDateTime dateUpdated) {
        return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{task-id}/max-hours-worked")
    public ResponseEntity<List<ReportResponseDto>> getByTaskWithMaxHoursWorked(@PathVariable(name = "task-id") long taskId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<ReportResponseDto> update(@PathVariable Long id, @RequestBody ReportRequestDto dto) {
        return ResponseEntity.ok(new ReportResponseDto());
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ReportResponseDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(new ReportResponseDto());
    }
}
