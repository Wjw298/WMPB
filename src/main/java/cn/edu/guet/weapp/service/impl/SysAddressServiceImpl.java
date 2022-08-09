package cn.edu.guet.weapp.service.impl;

import cn.edu.guet.weapp.bean.SysAddress;
import cn.edu.guet.weapp.mapper.SysAddressMapper;
import cn.edu.guet.weapp.service.SysAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/9 16:17
 * @Version 1.0
 */
@Service
public class SysAddressServiceImpl implements SysAddressService {

    @Autowired
    private SysAddressMapper sysAddressMapper;
    @Override
    public List<SysAddress> findAllAddress(String openId) {
        List<SysAddress> sysAddressList = sysAddressMapper.findAllAddress(openId);
        return sysAddressList;
    }
}
