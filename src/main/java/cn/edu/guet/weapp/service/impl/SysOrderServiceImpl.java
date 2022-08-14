package cn.edu.guet.weapp.service.impl;

import cn.edu.guet.weapp.bean.SysOrder;
import cn.edu.guet.weapp.mapper.SysOrderMapper;
import cn.edu.guet.weapp.service.SysOrderService;
import cn.edu.guet.weapp.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/7/29 11:29
 * @Version 1.0
 */
@Service
public class SysOrderServiceImpl implements SysOrderService {

    @Autowired
    private SysOrderMapper sysOrderMapper;

    @Override
    public List<SysOrder> findOrder() {
        List<SysOrder> sysOrderList = sysOrderMapper.finaOrder();
        return sysOrderList;
    }
    public List<SysOrder> orderByPay_type (int pay_type){
        List<SysOrder> sysOrderList = sysOrderMapper.orderByPay_type(pay_type);
        return sysOrderList;
    }

    @Override
    public int orderInsert(SysOrder sysOrder) {
        String id = PasswordUtils.getSalt();
        sysOrder.setOrder_id(id);
        int flag = sysOrderMapper.orderInsert(sysOrder);
        return flag;
    }

    @Override
    public int orderDelete(String order_id) {

        return sysOrderMapper.orderDelete(order_id);
    }

    @Override
    public int orderUpdate(SysOrder sysorder) {
        int flag = sysOrderMapper.orderUpdate(sysorder);
        return flag;
    }


}
