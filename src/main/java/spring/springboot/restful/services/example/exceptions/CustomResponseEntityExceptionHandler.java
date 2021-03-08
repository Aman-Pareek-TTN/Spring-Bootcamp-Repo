package spring.springboot.restful.services.example.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


//Exception handler class
@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ResourceNotFoundExceptionResponse> handleResourceNotFoundException(
            Exception ex, WebRequest request) throws Exception{

        ResourceNotFoundExceptionResponse resourceNotFoundExceptionResponse=
                new ResourceNotFoundExceptionResponse(new Date(),
                        ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(resourceNotFoundExceptionResponse,
                HttpStatus.NOT_FOUND);
    }

    //pt1 Ques 9 Validation failure handling
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        ResourceNotFoundExceptionResponse resourceNotFoundExceptionResponse=
                new ResourceNotFoundExceptionResponse(new Date(),
                        "Validation Failed",ex.getBindingResult().toString());

        return new ResponseEntity(resourceNotFoundExceptionResponse,
                HttpStatus.BAD_REQUEST);
    }


}
