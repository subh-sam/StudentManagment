package com.myOrganization.ERPSolution.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AttendanceNotFoundException extends RuntimeException{
    public AttendanceNotFoundException(String message){
        super(message);
    }
}
