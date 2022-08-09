package cn.edu.guet.weapp.service.impl;



import cn.edu.guet.weapp.bean.SysCustomer;
import cn.edu.guet.weapp.mapper.SysCustomerMapper;
import cn.edu.guet.weapp.service.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther wjw
 * @Date 2022/8/3 13:34
 * @Version 1.0
 */
@Service
public class SysCustomerServiceImpl implements SysCustomerService {

    @Autowired
    private SysCustomerMapper sysCustomerMapper;


    @Override
    public SysCustomer CustomerSelectByOpenId(String openId) {
        SysCustomer customer = sysCustomerMapper.CustomerSelectByOpenId(openId);
        return customer;
    }

    @Override
    public int customerInset(SysCustomer sysCustomer) {
        sysCustomer.setId(UUID.randomUUID().toString().replace("-",""));
        sysCustomer.setSalt(UUID.randomUUID().toString().replace("-",""));
        int flag = sysCustomerMapper.customerInsert(sysCustomer);
        return flag;
    }
}
