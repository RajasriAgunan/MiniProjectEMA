package com.example.MiniProjectEmployeeManagementSystem.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorDetails> handleResourceNotFoundExceptions
        (ResourceNotFoundException exception, WebRequest webRequest){
    ErrorDetails errorDetails=new ErrorDetails(
            LocalDateTime.now(),
            exception.getMessage(),
            webRequest.getDescription(false), "Employee_NotFound");
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException
        (EmailAlreadyExistException exception,WebRequest webRequest){
       ErrorDetails errorDetails=new ErrorDetails(
               LocalDateTime.now(),
               exception.getMessage(),
               webRequest.getDescription(false), "Employee_Email_Already_Exist");
   return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
 }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex,
             HttpHeaders headers,
             HttpStatusCode status,
            WebRequest request){
       Map<String, String> errors=new HashMap<>();
        List<ObjectError> objectErrors= ex.getBindingResult().getAllErrors();
           objectErrors.forEach(objectError ->
              errors.put(((FieldError) objectError).getField(),objectError.getDefaultMessage()));
           return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
     }
    }