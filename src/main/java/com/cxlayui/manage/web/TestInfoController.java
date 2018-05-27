package com.cxlayui.manage.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxlayui.manage.entity.TestInfoSearchDTO;
import com.cxlayui.manage.pojo.TestInfo;
import com.cxlayui.manage.service.TestInfoService;
import com.cxlayui.manage.utils.PageDataResult;

/**  
* @ClassName: TestInfoController 
* @Description: TODO  
* @author 陈翔  
* @date 2018年4月24日
*/ 
@Controller
@RequestMapping("/testInfo")
public class TestInfoController {

	private static final Logger logger = LoggerFactory
			.getLogger(TestInfoController.class);
	@Autowired
	private TestInfoService testInfoService;


	@RequestMapping("/testInfoList")
	public String toUserList(){
		return "/auth/testInfoList";
	}

	/**
	 * 分页查询用户列表
	 * @return ok/fail
	 */
	@RequestMapping(value = "/getTestInfoList", method = RequestMethod.GET)
	@ResponseBody
	public PageDataResult getUsers(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,TestInfoSearchDTO testInfoSearchDTO) {
		PageDataResult pdr =new PageDataResult();
		try {
			if(null==page){
				page=1;
			}
			if(null==limit){
				limit=10;
			}
			//获取用户和角色列表
			pdr = testInfoService.getTestInfoList(testInfoSearchDTO,page,limit);
			logger.debug("用户列表查询=pdr:" + pdr);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户列表查询异常！", e);
		}
		return pdr;
	}
	/**
	 * 设置用户[新增或更新]
	 * @return ok/fail
	 */
	@RequestMapping(value = "/addTestInfo", method = RequestMethod.POST)
	@ResponseBody
	public String addTestInfo(TestInfo testInfo) {
		try {
			return testInfoService.addTestInfo(testInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("设置用户[新增或更新]异常！", e);
		}
		return "操作失败，请您稍后再试";
	}
	
	
	/**
	 * 删除用户
	 * @return ok/fail
	 */
	@RequestMapping(value = "/delTestInfo", method = RequestMethod.POST)
	@ResponseBody
	public String delTestInfo(@RequestParam("id")Long id) {
		try {
			if(null==id ){
				return "请求参数有误，请您稍后再试";
			}
			testInfoService.delTestInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户异常！", e);
		}
		return "ok";
	}

	/**
	 * 查询用户数据
	 * @return map
	 */
	@RequestMapping(value = "/getTestInfo", method = RequestMethod.GET)
	@ResponseBody
	public TestInfo getTestInfo(@RequestParam("id")Long id) {
		logger.debug("查询用户数据！id:"+id);
		try {
			TestInfo  testInfo = testInfoService.getTestInfo(id);
			return testInfo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询用户数据异常！", e);
		}
		return null;
	}
}
