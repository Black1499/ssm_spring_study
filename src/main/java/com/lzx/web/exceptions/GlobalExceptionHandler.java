package com.lzx.web.exceptions;

import com.lzx.web.exceptions.PowerException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(PowerException.class)
    @ResponseBody
    public String catchPowerException(){
        return "Don't have power!!!!!";
    }
}