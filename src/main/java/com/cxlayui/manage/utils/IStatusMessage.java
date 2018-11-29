package com.cxlayui.manage.utils;

/**  
* @ClassName: IStatusMessage 
* @Description: 响应状态信息  
* @author 陈翔  
* @date 2018年4月24日
*/ 
public interface IStatusMessage {
	
	String getCode();

	String getMessage();
	
	public enum SystemStatus implements IStatusMessage{

		SUCCESS("1000","SUCCESS"), //请求成功
		ERROR("1001","ERROR"),	   //请求失败
		PARAM_ERROR("1002","PARAM_ERROR"), //请求参数有误
		SUCCESS_MATCH("1003","SUCCESS_MATCH"), //表示成功匹配
		PASSWORD_ERROR("1004","PASSWORD_ERROR"), //密码错误
		NO_LOGIN("1100","NO_LOGIN"), //未登录
		LOCK("1111","LOCK"); //用户已锁定
		private String code;
		private String message;

		private SystemStatus(String code,String message){
			this.code = code;
			this.message = message;
		}

		public String getCode(){
			return this.code;
		}

		public String getMessage(){
			return this.message;
		}
	}
}