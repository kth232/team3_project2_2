package org.choongang.start.validators.exceptions;

public class ValidationException extends CommonException{

    //유효성 검사 실패 오류 코드는 400으로 정함
    public ValidationException(String message) {
        super(message, 400);
    }
}
