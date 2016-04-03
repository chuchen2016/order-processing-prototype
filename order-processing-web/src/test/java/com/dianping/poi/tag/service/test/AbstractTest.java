package com.dianping.poi.tag.service.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration("classpath*:config/spring/appcontext-*.xml")
@Transactional
public abstract class  AbstractTest{
	  
}
