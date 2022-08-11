package cn.edu.guet.weapp.service;

import cn.edu.guet.weapp.bean.SysOrder;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/6 11:14
 * @Version 1.0
 */
public interface SysOrderService {
    List<SysOrder> findOrder (String openId);
}
