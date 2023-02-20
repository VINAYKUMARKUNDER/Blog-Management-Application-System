package com.myblog.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.Role;
import com.myblog.Repository.RoleRepository;
import com.myblog.Service.RoleService;
import com.myblog.utilDto.RoleDto;
import com.myblog.utilDto.RoleDtoAdding;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public RoleDto addRole(RoleDtoAdding roleDto) {
		Role role = modelMapper.map(roleDto, Role.class);
		roleRepository.save(role);
		return modelMapper.map(role, RoleDto.class);
	}

	@Override
	public RoleDto updateRole(RoleDtoAdding roleDto, Integer roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow(()-> new ResponseNotFoundException("Role", "role id", roleId));
		role.setName(roleDto.getName());
		roleRepository.save(role);
		return modelMapper.map(role, RoleDto.class);
	}
	

	

	@Override
	public RoleDto getRoleById(Integer roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow(()-> new ResponseNotFoundException("Role", "role id", roleId));
		return modelMapper.map(role, RoleDto.class);
	}
	

	@Override
	public List<RoleDto> getAllRole() {
		List<RoleDto> roleDtoeDtos = roleRepository.findAll().stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
		return roleDtoeDtos;
	}

	
}
