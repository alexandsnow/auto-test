package com.gy.daemon.portal.annotaion;

/**
 * Created by yang_gao on 2017/10/5.
 */
public class ApiInfo<T,V> {

    private String method;
    private String methodName;
    private String desc;
    private T request;
    private V response;

    public ApiInfo() {
    }

    public ApiInfo(String method, String methodName, String desc, T request, V response) {
        this.method = method;
        this.methodName = methodName;
        this.desc = desc;
        this.request = request;
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }

    public V getResponse() {
        return response;
    }

    public void setResponse(V response) {
        this.response = response;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
