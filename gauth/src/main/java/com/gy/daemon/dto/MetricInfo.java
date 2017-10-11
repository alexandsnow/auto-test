package com.gy.daemon.dto;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/11.
 */
public class MetricInfo {

    String requestPath;
    String requestParam;
    String elapse;
    String remoteIp;

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getElapse() {
        return elapse;
    }

    public void setElapse(String elapse) {
        this.elapse = elapse;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    @Override
    public String toString() {
        return "MetricInfo{" +
                "requestPath='" + requestPath + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", elapse='" + elapse + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                '}';
    }
}
