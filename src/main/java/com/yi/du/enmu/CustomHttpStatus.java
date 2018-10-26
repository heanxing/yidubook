package com.yi.du.enmu;

public enum  CustomHttpStatus {
    OK(200, ""),
    BAD_REQUEST(400, ""),

    USER_MSG_EXCEPTION(1001, "用户信息异常！"),
    UNAUTHC(1002, "您尚未登录或登录时间过长，请重新登录！"),
    UNPERM(1003, "您没有足够的权限执行该操作！"),
            ;

    public final int code;
    private final String desc;

    CustomHttpStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
