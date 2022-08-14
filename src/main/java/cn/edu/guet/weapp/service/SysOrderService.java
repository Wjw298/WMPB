package cn.edu.guet.weapp.service;

import cn.edu.guet.weapp.bean.SysOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/7/29 11:28
 * @Version 1.0
 */

public interface SysOrderService {
    /**
     * 查找订单*/
    List<SysOrder> findOrder ();
    List<SysOrder> orderByPay_type (int pay_type);
    int orderInsert(SysOrder sysOrder);
    int orderDelete(String order_id);
    int orderUpdate(SysOrder sysorder);
}
