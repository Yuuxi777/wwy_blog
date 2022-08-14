package com.example.wwy_blog.common;

public enum EnumExceptionType {

    PARAM_ILLEGAL(1000,"参数非法");

    private int errorCode;

    private String codeMessage;

    EnumExceptionType(int errorCode, String codeMessage){
        this.codeMessage = codeMessage;
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getCodeMessage() {
        return codeMessage;
    }
}
