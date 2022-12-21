package com.pharmacy.devin.controller.handler;


import com.pharmacy.devin.controller.dto.respostapadrao.DefaultErrorResponse;
import com.pharmacy.devin.exception.BadRequestException;
import com.pharmacy.devin.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultErrorResponse> tratarNotFoundException(Exception e){
        return new ResponseEntity<>(new DefaultErrorResponse(
                404,
                e.getMessage(),
                e.getCause(),
                e),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException   .class)
    public ResponseEntity<DefaultErrorResponse> tratarBadRequestException(Exception e){
        return new ResponseEntity<>(new DefaultErrorResponse(
                400,
                e.getMessage(),
                e.getCause(),
                e),
                HttpStatus.BAD_REQUEST);
    }

}
