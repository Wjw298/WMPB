package cn.edu.guet.weapp.service;

import cn.edu.guet.weapp.bean.SysCustomer;

/**
 * @Auther wjw
 * @Date 2022/8/3 13:34
 * @Version 1.0
 */
public interface SysCustomerService {
    SysCustomer CustomerSelectByOpenId(String openId);
    int customerInset(SysCustomer sysCustomer);
}
