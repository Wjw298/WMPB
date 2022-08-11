package cn.edu.guet.weapp.controller;

import cn.edu.guet.weapp.bean.SysCustomer;
import cn.edu.guet.weapp.http.HttpResult;
import cn.edu.guet.weapp.service.SysCustomerService;
import cn.edu.guet.weapp.util.GetOpenId;
import cn.edu.guet.weapp.util.GetUser;
import cn.edu.guet.weapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Auther wjw
 * @Date 2022/8/4 12:22
 * @Version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private SysCustomerService sysCustomerService;

    @PostMapping(value="/login")
    public HttpResult login(@RequestBody String code ) throws IOException {
        code = code.substring(code.indexOf(":")+2,code.lastIndexOf('"'));//将code转为可用形式
        // 系统登录认证
        String openId = GetOpenId.getOpenId(code);//拿到openId
        String token = tokenUtil.getToken(openId);
        SysCustomer customer = sysCustomerService.CustomerSelectByOpenId(openId) ;
        if(customer==null){
            HttpResult httpResult =HttpResult.ok(token);
            return httpResult;
        }
        customer.setOpenId("");
        HttpResult httpResult = HttpResult.ok(customer,token);
        return httpResult;

    }

    @PostMapping("/enroll")
    public int enroll(@RequestBody String  body) throws IOException {
        int flag;
        SysCustomer customer = GetUser.getUser(body);
        String openId=customer.getOpenId();
        SysCustomer customer1 = sysCustomerService.CustomerSelectByOpenId(openId) ;
        if(customer1==null){
            customer.setState(1);
            flag = sysCustomerService.customerInset(customer);
        }else{
            flag = sysCustomerService.customerUpdateState(openId,1);
        }
        return flag;
    }

    @PostMapping("exit")
    public int exit(@RequestBody String code) throws IOException {
        code = code.substring(code.indexOf(":")+2,code.lastIndexOf('"'));//将code转为可用形式
        String openId = GetOpenId.getOpenId(code);//拿到openId
        int flag =sysCustomerService.customerUpdateState(openId,0);
        return flag;
    }
}
