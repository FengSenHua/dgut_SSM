package cn.dgut.domain;

import java.util.List;

/**
 * 用户信息实体类
 */
public class UsersInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    //状态0 未开启 1 开启
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        if(statusStr!=null){
            if(statusStr.equals("关闭")){
                status=0;
            }else {
                status=1;
            }
        }
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        //状态0 未开启 1 开启
        if(status==0)
            statusStr="未开启";
        if (status==1)
            statusStr="开启";
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
