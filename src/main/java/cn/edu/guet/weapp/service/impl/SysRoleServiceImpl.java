package cn.edu.guet.weapp.service.impl;

import java.util.List;

import cn.edu.guet.weapp.bean.SysRole;
import cn.edu.guet.weapp.mapper.SysRoleMapper;
import cn.edu.guet.weapp.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liwei
 * @Date 2021-08-13 18:12
 */
@Service
public class SysRoleServiceImpl  implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> findAll() {
		return sysRoleMapper.findAll();
	}
	
}
