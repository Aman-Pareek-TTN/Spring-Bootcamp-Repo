package spring.springboot.restful.services.example.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionResponse
{
    Date timestamp;
    String message;
    String details;

    public ResourceNotFoundExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
