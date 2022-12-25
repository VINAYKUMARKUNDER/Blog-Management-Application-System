package com.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.Service.RoleService;
import com.myblog.utilDto.RoleDto;
import com.myblog.utilDto.RoleDtoAdding;


@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/")
	public ResponseEntity<RoleDto> createRoll(@RequestBody RoleDtoAdding rDto) {
		RoleDto role = roleService.addRole(rDto);
		return new ResponseEntity<RoleDto>(role, HttpStatus.CREATED);
	}

	@PutMapping("/{roleId}")
	public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDtoAdding rDto, @PathVariable("roleId") Integer roleId) {
		RoleDto role = roleService.updateRole(rDto, roleId);
		return new ResponseEntity<RoleDto>(role, HttpStatus.OK);
	}
	
	
	@GetMapping("/{roleId}")
	public ResponseEntity<RoleDto> getRoleById( @PathVariable("roleId") Integer roleId) {
		RoleDto role = roleService.getRoleById(roleId);
		return new ResponseEntity<RoleDto>(role, HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<RoleDto>> getAllRole() {
		List<RoleDto> allRole = roleService.getAllRole();
		return new ResponseEntity<List<RoleDto>>(allRole, HttpStatus.OK);
	}

}
