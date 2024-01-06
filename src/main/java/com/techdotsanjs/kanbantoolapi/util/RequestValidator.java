package com.techdotsanjs.kanbantoolapi.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;

public class RequestValidator {

    public static HashMap<String, String> getErrorMap(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            HashMap<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return errorMap;
        }
        return null;
    }
}
