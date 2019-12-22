package com.cc;

import com.alibaba.fastjson.JSON;
import com.cc.model.UserT;
import com.cc.service.UserTService;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);

    @Resource
    private UserTService userTService = null;

    @org.junit.Test
    public void test1() {
        UserT userT = userTService.getUserById(new Integer(1));
        System.out.println(JSON.toJSON(userT));
    }

}
