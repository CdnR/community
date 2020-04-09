package edu.example.mycommunity.exception;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;


    public CustomizeException(ICustomizeErrorCode customizeErrorCode) {
        this.message = customizeErrorCode.getMessage();
        this.code = customizeErrorCode.getCode();
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
