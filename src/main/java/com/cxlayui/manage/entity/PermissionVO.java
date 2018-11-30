package com.cxlayui.manage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PermissionVO implements Serializable{
	private static final long serialVersionUID = -2783081162690878303L;
	private String id;

	private String name;

	private String pid;

	private String istype;

	private String code;

	private String page;

	private String icon;

	private String zindex;

	private boolean checked;

	private boolean open;


	public boolean getOpen() {
		return true;
	}


	@Override public String toString() {
		return "PermissionVO{" + "id='" + id + '\'' + ", name='" + name + '\''
				+ ", pId='" + pid + '\'' + ", istype='" + istype + '\''
				+ ", code='" + code + '\'' + ", page='" + page + '\''
				+ ", icon='" + icon + '\'' + ", zindex='" + zindex + '\''
				+ ", checked=" + checked + ", open=" + open + '}';
	}
}