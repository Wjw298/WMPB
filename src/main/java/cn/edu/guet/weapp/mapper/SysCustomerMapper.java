package cn.edu.guet.weapp.mapper;

import cn.edu.guet.weapp.bean.SysCustomer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther wjw
 * @Date 2022/8/3 13:37
 * @Version 1.0
 */
@Mapper
public interface SysCustomerMapper {
    SysCustomer CustomerSelectByOpenId(String openId);
    int customerInsert(SysCustomer customer);
}
