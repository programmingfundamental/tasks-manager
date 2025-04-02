package bg.tu_varna.sit.task_manager.exception;

import bg.tu_varna.sit.task_manager.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/***
 * Добавено в лабораторно упражнение 8
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDetail errorDetails = ErrorDetail
                .builder()
                .time(LocalDateTime.now())
                .message(exception.getMessage())
                .build();
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
