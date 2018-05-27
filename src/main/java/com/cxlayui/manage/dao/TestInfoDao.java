package com.cxlayui.manage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cxlayui.manage.entity.TestInfoSearchDTO;
import com.cxlayui.manage.pojo.TestInfo;
import com.cxlayui.manage.pojo.TestInfoExample;

@Repository
public class TestInfoDao {
	
	@Autowired
	private TestInfoMapper testInfoMapper;
	
    public List<TestInfo> getTestInfoList(TestInfoSearchDTO testInfoSearchDTO){
    	TestInfoExample example = new TestInfoExample();
    	if(testInfoSearchDTO!=null) {
    		TestInfoExample.Criteria criteria =example.createCriteria(); 
    		if(testInfoSearchDTO.getUage()!=null) {
    			criteria.andAgeEqualTo(testInfoSearchDTO.getUage());
    		}
    		if(testInfoSearchDTO.getUname()!=null && !"".equals(testInfoSearchDTO.getUname())) {
    			criteria.andNameEqualTo(testInfoSearchDTO.getUname());
    		}
    	}
        List<TestInfo> list = testInfoMapper.selectByExample(example);
        return list;
    }
    
}
