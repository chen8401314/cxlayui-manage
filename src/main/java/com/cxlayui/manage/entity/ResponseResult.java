package com.cxlayui.manage.entity;

import java.io.Serializable;

import com.cxlayui.manage.utils.IStatusMessage;
import lombok.Data;

/**  
* @ClassName: ResponseResult 
* @Description:  前端请求响应结果,code:编码,message:描述,obj对象，可以是单个数据对象，数据列表或者PageInfo  
* @author 陈翔  
* @date 2018年4月24日
*/
@Data
public class ResponseResult implements Serializable {
	
	private static final long serialVersionUID = 7285065610386199394L;

	private String code;
	private String message;
	private Object obj;
	
	public ResponseResult() {
		this.code = IStatusMessage.SystemStatus.SUCCESS.getCode();
		this.message = IStatusMessage.SystemStatus.SUCCESS.getMessage();
	}
	
	public ResponseResult(IStatusMessage statusMessage){
		this.code = statusMessage.getCode();
		this.message = statusMessage.getMessage();
		
	}

}
