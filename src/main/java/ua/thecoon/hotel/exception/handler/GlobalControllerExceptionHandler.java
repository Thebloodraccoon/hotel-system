package ua.thecoon.hotel.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ua.thecoon.hotel.model.dto.ErrorDTO;

@Slf4j
@ControllerAdvice(annotations = {RestController.class})
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleUnHandled(Exception e){
        String message = e.getMessage();
        ErrorDTO error = new ErrorDTO();
        error.setMessage(message);
        log.error("Error: {}", message);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}