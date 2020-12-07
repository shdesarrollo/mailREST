package com.dev.mail.common;

public enum Code {

	SUCCESS(0,"success"),

    BAD_REQUEST(4000, "Bad Request"),

    NOT_SUPPORTED_METHOD(4005, "Tot Supported Method"),

    INTERNAL_SERVER_ERROR(5000,"internal server error");

    private final int code;

    private final String message;

    Code(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
	
}
