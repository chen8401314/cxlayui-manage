package com.cxlayui.manage.entity;

import lombok.Data;

@Data
public class UserRoleDTO {
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

	private String roleNames;

}