package com.gy.daemon.portal.dto;

/**
 * Created by yang_gao on 2017/10/4.
 */
public class TestCaseBaseDto {

    String id;
    String tcName;
    String appId;
    String appName;
    String apiName;
    String createBy;
    String testTime;
    String isPass;
    String createTime;
    String url;
    String method;
    String param;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "TestCaseBaseDto{" +
                "id='" + id + '\'' +
                ", tcName='" + tcName + '\'' +
                ", appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                ", apiName='" + apiName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", testTime='" + testTime + '\'' +
                ", isPass='" + isPass + '\'' +
                ", createTime='" + createTime + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
