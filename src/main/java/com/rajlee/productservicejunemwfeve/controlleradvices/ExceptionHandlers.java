package com.rajlee.productservicejunemwfeve.controlleradvices;

import com.rajlee.productservicejunemwfeve.dtos.ArithmeticExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto=new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something went wrong");
        return new ResponseEntity<>(arithmeticExceptionDto,HttpStatus.OK);
    }

}
