package com.cxlayui.manage.entity;

import lombok.Data;

/**
* @ClassName: UserSearchDTO 
* @Description: TODO  
* @author 陈翔  
* @date 2018年4月24日
*/
@Data
public class UserSearchDTO {

	private Integer page;

	private Integer limit;

	private String uname;

	private String umobile;

	private String insertTimeStart;

	private String insertTimeEnd;

}
