package com.myblog.utilDto;

import java.util.ArrayList;
import java.util.List;

import com.myblog.Model.User;

import lombok.Data;

@Data
public class RoleDto {
	private Integer roleId;
	private String name;
	private List<User> users = new ArrayList<>();

}
