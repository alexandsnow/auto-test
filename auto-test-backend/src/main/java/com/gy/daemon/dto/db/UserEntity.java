package com.gy.daemon.dto.db;

public class UserEntity {
    private Integer uid;

    private String userCname;

    private String userEname;

    private String userGroup;

    private String userRole;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname == null ? null : userCname.trim();
    }

    public String getUserEname() {
        return userEname;
    }

    public void setUserEname(String userEname) {
        this.userEname = userEname == null ? null : userEname.trim();
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup == null ? null : userGroup.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }
}