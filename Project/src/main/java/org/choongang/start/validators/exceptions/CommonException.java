package org.choongang.start.validators.exceptions;

public class CommonException extends RuntimeException{
    private int code; //에러코드

    public CommonException(String message, int code){
        super(message);
        this.code = code;
    }
}
