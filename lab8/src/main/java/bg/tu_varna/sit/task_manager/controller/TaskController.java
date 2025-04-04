package bg.tu_varna.sit.task_manager.controller;

import bg.tu_varna.sit.task_manager.exception.ResourceNotFoundException;
import bg.tu_varna.sit.task_manager.model.dto.request.TaskRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.TaskResponseDto;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskResponseDto());
    }
    @GetMapping()
    public ResponseEntity<List<TaskResponseDto>> getAll() throws ResourceNotFoundException {
        throw new ResourceNotFoundException(0, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> get(@PathVariable Long id) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<TaskResponseDto> update(@PathVariable Long id, @RequestBody TaskRequestDto dto) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<TaskResponseDto> delete(@PathVariable Long id) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
    }
}
