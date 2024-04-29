package com.talk.comm.exception;

import java.util.Map;

public class CustomValidationExcetion extends RuntimeException{
    private Map<String, String> errorMap;

    public CustomValidationExcetion(String message, Map<String, String> errormap){
        super(message);
        this.errorMap = errormap;
    }
}
