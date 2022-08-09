package cn.edu.guet.weapp.controller;

import cn.edu.guet.weapp.bean.SysCustomer;
import cn.edu.guet.weapp.service.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther wjw
 * @Date 2022/8/6 10:05
 * @Version 1.0
 */
@RestController
public class CustomerController {
    private String openId;

    @Autowired
    private SysCustomerService sysCustomerService;

    public boolean verifyToken(String openId){
        SysCustomer customer = sysCustomerService.CustomerSelectByOpenId(openId);
        if(customer!=null){
            return true;
        }
        return false;
    }
}
