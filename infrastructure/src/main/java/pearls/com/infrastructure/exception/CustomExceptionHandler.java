package pearls.com.infrastructure.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final String BAD_REQUEST = "400 BAD_REQUEST";
    private static final String ERROR_CONSUMING_SERVICES = "Error processing data. Please confirm your request data is valid.";
    private static final String UNKNOWN_ERROR = "Unknown error.";
    private static final String NULL_DATA = "Data error. Please confirm your request has all the data required.";
    private static final String REQUEST_BODY_IS_MISSING = "request body is missing";
    private static final String JSON_PARSE_ERROR = "JSON parse error";


    @ExceptionHandler({Exception.class, CustomException.class})
    public final ResponseEntity<String> handleAllExceptions(Exception exception){
        if(exception.getClass().equals(CustomException.class)){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(exception.getMessage() == null){
            return new ResponseEntity<>(NULL_DATA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(isRequestError(exception)){
            return  new ResponseEntity<>(ERROR_CONSUMING_SERVICES, HttpStatus.BAD_REQUEST);
        }
        exception.printStackTrace();
        return new ResponseEntity<>(UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean isRequestError(Exception exception) {
        return exception.getMessage().contains(BAD_REQUEST) || exception.getMessage().contains(REQUEST_BODY_IS_MISSING) || exception.getMessage().contains(JSON_PARSE_ERROR);
    }
}
