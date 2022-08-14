package cn.edu.guet.weapp.controller;

import cn.edu.guet.weapp.bean.SysOrder;
import cn.edu.guet.weapp.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/7/29 10:41
 * @Version 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private SysOrderService sysOrderService;

    @PostMapping("findOrder")//查找order列表
    public List<SysOrder> findOrder (){
        List<SysOrder> sysOrderList = sysOrderService.findOrder();
        return add(sysOrderList);
    }

    @GetMapping("orderByPay_type")//通过pay_type查找order列表
    public List<SysOrder> orderByPay_type (int pay_type){
        List<SysOrder> sysOrderList = sysOrderService.orderByPay_type(pay_type);
        return add(sysOrderList);
    }
    @GetMapping("orderInsert")//新增订单
    public int orderInsert( String username,double total_amount, double pay_amount, String create_time,int pay_type,int status){
        SysOrder sysOrder = new SysOrder();
        sysOrder.setUsername(username);
        sysOrder.setTotal_amount(total_amount);
        sysOrder.setPay_amount(pay_amount);
        sysOrder.setCreate_time(create_time);
        sysOrder.setPay_type(pay_type);
        sysOrder.setStatus(status);
        int flag = sysOrderService.orderInsert(sysOrder);
        return flag;
    }
    @ResponseBody
    @GetMapping("orderDelete")//删除订单
    public int orderDelete(String order_id){
        System.out.println("id: "+order_id);
        int flag = sysOrderService.orderDelete(order_id);
        return flag;
    }
    
    @GetMapping("orderUpdate")//修改订单
    public int orderUpdate(String order_id,String username,double total_amount, double pay_amount, String create_time,int pay_type,int status){
        SysOrder sysOrder = new SysOrder();
        sysOrder.setOrder_id(order_id);
        sysOrder.setUsername(username);
        sysOrder.setTotal_amount(total_amount);
        sysOrder.setPay_amount(pay_amount);
        sysOrder.setCreate_time(create_time);
        sysOrder.setPay_type(pay_type);
        sysOrder.setStatus(status);
        int flag=sysOrderService.orderUpdate(sysOrder);
        return flag;
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

