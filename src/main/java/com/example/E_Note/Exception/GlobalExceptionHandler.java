package com.example.E_Note.Exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception e){
     log.error("GlobalEXceptionHandler",e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handlerNullPointerException(Exception e){
        log.error("GlobalEXceptionHandler",e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity handlerResouceNotFoundException(Exception e){
        log.error("GlobalEXceptionHandler",e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handlerValidationException (ValidationException e){
        log.error("GlobalEXceptionHandler",e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(e.getError(),HttpStatus.BAD_REQUEST);
    }

}
