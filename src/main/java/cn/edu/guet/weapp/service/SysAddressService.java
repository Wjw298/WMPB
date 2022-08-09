package cn.edu.guet.weapp.service;

import cn.edu.guet.weapp.bean.SysAddress;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/9 16:17
 * @Version 1.0
 */
public interface SysAddressService {
    List<SysAddress> findAllAddress(String openId);
}
