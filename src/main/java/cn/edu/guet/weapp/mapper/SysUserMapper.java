package cn.edu.guet.weapp.mapper;

import cn.edu.guet.weapp.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper {
    SysUser findByName(@Param("name") String name);
}