package cn.edu.guet.weapp.util;

public class AppUser{

    private String appId;
    private String secret;

    public AppUser(){
        appId="wx4fb2df820fbe8a1d";
        secret="4012b877e9e1800d3461e8efbd6a9761";
    }
    public String getAppId(){
        return this.appId;
    }
    public String getSecret(){
        return this.secret;
    }
}