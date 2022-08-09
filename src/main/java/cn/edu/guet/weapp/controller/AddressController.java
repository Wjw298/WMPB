package cn.edu.guet.weapp.controller;

import cn.edu.guet.weapp.bean.SysAddress;
import cn.edu.guet.weapp.service.SysAddressService;
import cn.edu.guet.weapp.util.GetOpenId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/9 16:08
 * @Version 1.0
 */
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private SysAddressService sysAddressService;

    @GetMapping("findAllAddress")
    public List<SysAddress> findAllAddress(String code) throws IOException {
        String openId = GetOpenId.getOpenId(code);//拿到openId
        List<SysAddress> sysAddressList = sysAddressService.findAllAddress(openId);

        return sysAddressList;
    }
}
