package cn.edu.guet.weapp.mapper;

import cn.edu.guet.weapp.bean.SysOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/6 11:14
 * @Version 1.0
 */
@Mapper
public interface SysOrderMapper {
    List<SysOrder> finaOrder(String openId);
}
