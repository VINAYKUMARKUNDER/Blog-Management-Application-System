package com.myblog.Service;

import java.util.List;

import com.myblog.utilDto.RoleDto;
import com.myblog.utilDto.RoleDtoAdding;

public interface RoleService {
	
	RoleDto addRole(RoleDtoAdding roleDto);
	RoleDto updateRole(RoleDtoAdding roleDto,Integer roleId);
	RoleDto getRoleById(Integer roleId);
	List<RoleDto> getAllRole();
	

}
