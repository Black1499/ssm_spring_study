package com.lzx.web;

import com.lzx.Exceptions.PowerException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
public class HandlerAndAdvice {

    @ExceptionHandler(PowerException.class)
    @ResponseBody
    public String catchPowerException(){
        return "Don't have power!!!!!";
    }
}