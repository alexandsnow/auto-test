package com.gy.daemon.lib.common.statecode;

/**
 * Created by yang_gao on 2017/10/1.
 */
public enum ServiceCode {

    SUCCESS("S0001","SUCCESS"),

    ARGUMENT_INVALID("AI0001","ARGUMENT INVALID"),

    DB_OPERATION_ERROR("DOES0000","DB OPERATION ERROR"),
    DB_OPERATION_ERROR_INSERT("DOES0001","DB INSERT ERROR"),
    DB_OPERATION_ERROR_UPDATE("DOES0002","DB UPDATE ERROR"),
    DB_OPERATION_ERROR_QUERY("DOES0003","DB QUERY ERROR"),

    SYSTEM_ERROR("SE0001","SYSTEM ERROR"),

    SERVICE_UNAVAILABLE("SNA0001","SERVICE UNAVAILABLE");


    private String code;
    private String msg;
    ServiceCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServiceCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                "} " + super.toString();
    }
}
