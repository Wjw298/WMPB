package cn.edu.guet.weapp.service.impl;

import cn.edu.guet.weapp.bean.SysAddress;
import cn.edu.guet.weapp.mapper.SysAddressMapper;
import cn.edu.guet.weapp.service.SysAddressService;
import cn.edu.guet.weapp.util.GetOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    @Override
    public int insertAddress(SysAddress sysAddress) throws IOException {
        String code=sysAddress.getAddress_openId();
        sysAddress.setAddress_id(UUID.randomUUID().toString().replace("-",""));
        sysAddress.setAddress_openId(GetOpenId.getOpenId(code));
        int flag=sysAddressMapper.insertAddress(sysAddress);
        return flag;
    }
    @Override
    public int updateAddress(SysAddress sysAddress) throws IOException {
        String code=sysAddress.getAddress_openId();
        String openId=GetOpenId.getOpenId(code);
        sysAddress.setAddress_openId(openId);
        int flag=sysAddressMapper.updateAddress(sysAddress);
        return flag;
    }

    @Override
    public int deleteAddress(SysAddress sysAddress) throws IOException {
        String code=sysAddress.getAddress_openId();
        String openId=GetOpenId.getOpenId(code);
        sysAddress.setAddress_openId(openId);
        int flag=sysAddressMapper.deleteAddress(sysAddress);
        return flag;
    }
}
