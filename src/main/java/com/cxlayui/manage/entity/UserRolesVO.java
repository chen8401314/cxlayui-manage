package com.cxlayui.manage.entity;

import java.util.List;

import com.cxlayui.manage.pojo.UserRoleKey;
import lombok.Data;

@Data
public class UserRolesVO {
	private Integer id;

	private String username;

	private String mobile;

	private String email;

	private String password;

	private Integer insertUid;

	private String insertTime;

	private String updateTime;

	private boolean isDel;

	private boolean isJob;

	private List<UserRoleKey> userRoles;

}