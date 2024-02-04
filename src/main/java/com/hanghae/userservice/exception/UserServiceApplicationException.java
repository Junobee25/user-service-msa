package com.hanghae.userservice.exception;

import com.hanghae.userservice.domain.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserServiceApplicationException extends RuntimeException{

    private final ErrorCode errorCode;
    private final String message;

    public UserServiceApplicationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return (message == null) ? errorCode.getMessage() : String.format("%s. %s", errorCode.getMessage(), message);
    }
}
