package cn.edu.guet.weapp.mapper;

import cn.edu.guet.weapp.bean.SysAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/8/9 16:18
 * @Version 1.0
 */
@Mapper
public interface SysAddressMapper {
    List<SysAddress> findAllAddress(String openId);
}
