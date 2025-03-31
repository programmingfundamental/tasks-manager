package bg.tu_varna.sit.task_manager.controller;

import bg.tu_varna.sit.task_manager.model.dto.request.TaskRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/***
 * Добавено в лабораторно упражнение 7
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @PostMapping()
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto dto) {
        return ResponseEntity.ok(new TaskResponseDto());
    }
    @GetMapping()
    public ResponseEntity<List<TaskResponseDto>> getAll() {
        return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(new TaskResponseDto());
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<TaskResponseDto> update(@PathVariable Long id, @RequestBody TaskRequestDto dto) {
        return ResponseEntity.ok(new TaskResponseDto());
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<TaskResponseDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(new TaskResponseDto());
    }
}
