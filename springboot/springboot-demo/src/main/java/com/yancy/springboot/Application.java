package com.yancy.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yancy.springboot.db.OracleHanderService;

@SpringBootApplication
@RestController
@ImportResource({"classpath:spring-application.xml"})
@RequestMapping("/")
public class Application {

	@Autowired
	private OracleHanderService oracleHanderService;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping(value = "backup", method = RequestMethod.GET)
	@ResponseBody
	public String dbbackup() {
	   return oracleHanderService.dbFullBackup("DATA_PUMP_DIR");
	}
	
	@RequestMapping(value = "pre", method = RequestMethod.GET)
	@ResponseBody
	public String dbPreduction(String fileName) {
	   return oracleHanderService.dbPreduction(fileName,"DATA_PUMP_DIR");
	}
	
	@RequestMapping(value = "fileNames", method = RequestMethod.GET)
	@ResponseBody
	public String getBackupFileNames() {
	   return oracleHanderService.getBackupFileNames("DATA_PUMP_DIR");
	}
}
