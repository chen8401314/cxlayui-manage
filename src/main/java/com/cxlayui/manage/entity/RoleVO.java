package com.cxlayui.manage.entity;

import java.util.List;

import com.cxlayui.manage.pojo.RolePermissionKey;
import lombok.Data;

/**  
* @ClassName: RoleVO 
* @Description:   
* @author 陈翔  
* @date 2018年4月24日
*/
@Data
public class RoleVO {

	private Integer id;

	private String roleName;

	private String descpt;

	private String code;

	private Integer insertUid;

	private String insertTime;
	//角色下的权限ids
	private List<RolePermissionKey> rolePerms;

}
