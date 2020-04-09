package edu.example.mycommunity.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找的问题不见了"),
    TARGET_PARAM_NOT_FOUND(2002,"你找的问题不见了"),
    NO_LOGIN(2003,"未登录，不能进行评论"),
    SYS_ERROR(2004,"服务器出错"),
    TYPE_PARAM_WRONG(2005,"评论类型不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在了"),
    ;


    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
