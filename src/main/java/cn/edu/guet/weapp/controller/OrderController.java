package cn.edu.guet.weapp.controller;

import cn.edu.guet.weapp.bean.SysOrder;
import cn.edu.guet.weapp.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/6 11:13
 * @Version 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private SysOrderService sysOrderService;

    @GetMapping ("findOrder")//查找order列表
    public List<SysOrder> findOrder (){
        List<SysOrder> sysOrderList = sysOrderService.findOrder();
        return add(sysOrderList);
    }
    public List<SysOrder> add (List<SysOrder> sysOrderList){
        for(SysOrder order :sysOrderList){
            switch(order.getPay_type()){
                case 0:order.setPay_typeS("未支付");break;
                case 1:order.setPay_typeS("支付宝");break;
                case 2:order.setPay_typeS("微信");
            }
            switch(order.getStatus()){
                case 0:order.setStatusS("待付款");break;
                case 1:order.setStatusS("待发货");break;
                case 2:order.setStatusS("已发货");break;
                case 3:order.setStatusS("已完成");break;
                case 4:order.setStatusS("已关闭");break;
                case 5:order.setStatusS("无效订单");
            }
        }
        return sysOrderList;
    }
}
