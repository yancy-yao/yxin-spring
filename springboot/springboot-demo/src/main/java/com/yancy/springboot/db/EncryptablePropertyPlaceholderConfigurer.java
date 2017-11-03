package com.yancy.springboot.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
	  public static final Logger logger = LoggerFactory.getLogger(EncryptablePropertyPlaceholderConfigurer.class);
	  private static Map<String, Object> propertiesMap;

	  protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)throws BeansException
	  {
	    try
	    {
	      String password = props.getProperty("jdbc.trader.password");
	      if ((password != null) && (!"".equals(password)))
	      {
	        props.setProperty("jdbc.trader.password", DESUtil.decrypt(password, "THS.10JQKA"));
	        logger.debug("解密后密码:" + DESUtil.decrypt(password, "THS.10JQKA"));
	        super.processProperties(beanFactory, props);
	      }

	      propertiesMap = new HashMap<String, Object>();
	      for (Object key: props.keySet()) {
	        String keyStr = key.toString();
	        String value = props.getProperty(keyStr);
	        propertiesMap.put(keyStr, value);
	      }
	    }
	    catch (Exception e)
	    {
	      throw new BeanInitializationException(e.getMessage());
	    }
	  }

	  public static Object getContextProperty(String name) {
	    return propertiesMap.get(name);
	  }
	}
