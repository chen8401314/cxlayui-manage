package com.cxlayui.manage.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxlayui.manage.dao.TestInfoDao;
import com.cxlayui.manage.dao.TestInfoMapper;
import com.cxlayui.manage.entity.TestInfoSearchDTO;
import com.cxlayui.manage.entity.UserRolesVO;
import com.cxlayui.manage.entity.UserSearchDTO;
import com.cxlayui.manage.pojo.TestInfo;
import com.cxlayui.manage.pojo.User;
import com.cxlayui.manage.pojo.UserRoleKey;
import com.cxlayui.manage.utils.PageDataResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**  
* @ClassName: TestInfoServiceImpl 
* @Description: TODO  
* @author 陈翔  
* @date 2018年4月24日
*/ 
@Service
public class TestInfoServiceImpl implements TestInfoService {
	private static final Logger logger = LoggerFactory
			.getLogger(TestInfoServiceImpl.class);
	@Autowired
	private TestInfoDao testInfoDao;
	@Autowired
	private TestInfoMapper testInfoMapper;
	@Override
	public PageDataResult getTestInfoList(TestInfoSearchDTO testInfoSearchDTO,int page, int limit) {
		PageDataResult pdr=new PageDataResult();
		PageHelper.startPage(page, limit);
		List<TestInfo> testInfoList = testInfoDao.getTestInfoList(testInfoSearchDTO);
		//获取分页查询后的数据
	    PageInfo<TestInfo> pageInfo = new PageInfo<>(testInfoList);
		//设置获取到的总记录数total：
		pdr.setTotals(Long.valueOf(pageInfo.getTotal()).intValue());
		//将角色名称提取到对应的字段中
		pdr.setList(testInfoList);
		return pdr;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=30000,rollbackFor={RuntimeException.class, Exception.class})
	public String addTestInfo(TestInfo testInfo) {
		if(testInfo.getId()==null || testInfo.getId()==0) {
			testInfoMapper.insertSelective(testInfo);
		}else {
			testInfoMapper.updateByPrimaryKey(testInfo);
		}
		return "ok";
	}
	
	@Override
	public int delTestInfo(Long id) {
		return this.testInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TestInfo getTestInfo(Long id) {
		//获取用户及他对应的roleIds
		return this.testInfoMapper.selectByPrimaryKey(id);

	}
}
