package cn.edu.guet.weapp.service.impl;

import cn.edu.guet.weapp.bean.SysOrder;
import cn.edu.guet.weapp.mapper.SysOrderMapper;
import cn.edu.guet.weapp.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/6 11:14
 * @Version 1.0
 */
@Service
public class SysOrderServiceImpl implements SysOrderService {
    @Autowired
    private SysOrderMapper sysOrderMapper;
    @Override
    public List<SysOrder> findOrder(String openId) {
        List<SysOrder> sysOrderList = sysOrderMapper.finaOrder(openId);
        for(SysOrder order:sysOrderList){
            order.setOrder_openId("");
        }
        return sysOrderList;
    }
}
