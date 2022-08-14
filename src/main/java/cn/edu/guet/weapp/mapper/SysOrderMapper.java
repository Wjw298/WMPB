package cn.edu.guet.weapp.mapper;

import cn.edu.guet.weapp.bean.SysOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/7/29 11:31
 * @Version 1.0
 */
@Mapper
public interface SysOrderMapper {
    List<SysOrder> finaOrder();
    List<SysOrder> orderByPay_type (int pay_type);
    int orderInsert(SysOrder sysOrder);
    int orderDelete(String order_id);

    int orderUpdate(SysOrder sysorder);
}
