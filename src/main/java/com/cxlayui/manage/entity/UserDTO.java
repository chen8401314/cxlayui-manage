package com.cxlayui.manage.entity;

import lombok.Data;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.ValidateWithMethod;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@Data
public class UserDTO {

	private Integer id;
	@NotNull(message = "用户名不能为空，请您先填写用户名")
	private String username;
	
	private String mobile;

	private String email;
	@NotNull(message = "密码不能为空，请您先填写手机号")
	@MatchPattern(pattern = "^[0-9_a-zA-Z]{3,20}$", message = "密码长度为3-20")
	private String password;
	@NotNull(message = "图片验证码不能为空，请您先填写验证码")
	@MatchPattern(pattern = "\\w{4}$", message = "图片验证码有误，请您重新填写")
	private String code;

	private String smsCode;

	private static final Pattern CODE = Pattern.compile("[0-9]{6}$");

	/**
	 *	是否为6位短信验证码
	 * @param smsCode
	 * @return
	 */
	private boolean isValidateSmsCode(String smsCode){
		if(StringUtils.isNotBlank(smsCode)){
			if (!CODE.matcher(smsCode).matches()) {
				return false;
			}
		}
		return true;
	}

}