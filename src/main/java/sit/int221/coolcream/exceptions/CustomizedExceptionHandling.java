package sit.int221.coolcream.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler{

    @ExceptionHandler(IcecreamException.class)
    public ResponseEntity<Object> handleExceptions(IcecreamException icecreamException, WebRequest webRequest) {
        ExceptionResponse response =
                new ExceptionResponse(icecreamException.getErrorCode(),icecreamException.getMessage(),LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}