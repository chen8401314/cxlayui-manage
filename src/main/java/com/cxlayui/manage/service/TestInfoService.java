package com.cxlayui.manage.service;

import com.cxlayui.manage.entity.TestInfoSearchDTO;
import com.cxlayui.manage.pojo.TestInfo;
import com.cxlayui.manage.utils.PageDataResult;

/**  
* @ClassName: TestInfoService 
* @Description: TODO  
* @author 陈翔  
* @date 2018年4月24日
*/ 
public interface TestInfoService {
	/**
	 * 分页查询用户列表
	 * @param page
	 * @param limit
	 * @return
	 */
	public PageDataResult getTestInfoList(TestInfoSearchDTO testInfoSearchDTO,int page, int limit);
	
	public String addTestInfo(TestInfo testInfo);
	
	public int delTestInfo(Long id);

	public TestInfo getTestInfo(Long id) ;
}
