package com.dianping.poi.tag.service.test;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

public class JUnit4ClassRunner extends SpringJUnit4ClassRunner{

	public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
		// TODO Auto-generated constructor stub
	}
	
	static {
	    try {
	      Log4jConfigurer.initLogging( "classpath:config/log/log4j.xml" );
	    }
	    catch( FileNotFoundException ex ) {
	      System.err.println( "Cannot Initialize log4j" );
	    }
	  }
}
 