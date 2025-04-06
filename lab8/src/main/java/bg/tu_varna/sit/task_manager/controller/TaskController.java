package bg.tu_varna.sit.task_manager.controller;

import bg.tu_varna.sit.task_manager.exception.ResourceNotFoundException;
import bg.tu_varna.sit.task_manager.model.dto.request.TaskRequestDto;
import bg.tu_varna.sit.task_manager.model.dto.response.TaskResponseDto;
import jakarta.validation.Valid;
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
    public ResponseEntity<TaskResponseDto> create(@Valid @RequestBody TaskRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskResponseDto());
    }
    @GetMapping()
    public ResponseEntity<List<TaskResponseDto>> getAll() throws ResourceNotFoundException {
        throw new ResourceNotFoundException(0, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> get(@Valid @PathVariable Long id) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new TaskResponseDto());
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<TaskResponseDto> update(@PathVariable Long id,@Valid  @RequestBody TaskRequestDto dto) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new TaskResponseDto());
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<TaskResponseDto> delete(@Valid @PathVariable Long id) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(id, TaskResponseDto.class);  //Добавено в лабораторно упражнение 8
        //return ResponseEntity.ok(new TaskResponseDto());
    }
}
