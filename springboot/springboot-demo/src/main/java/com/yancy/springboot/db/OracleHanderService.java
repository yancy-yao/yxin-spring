package com.yancy.springboot.db;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OracleHanderService {
	  private static final Logger logger = LoggerFactory.getLogger(OracleHanderService.class);

	  @Value("${jdbc.trader.username}")
	  private String userName;
	  private String userPass;

	  @Value("${jdbc.trader.serverAddr}")
	  private String serverAddr;

	  @Value("${jdbc.backup.dir}")
	  private String backupDir;
	  
	  @Value("${jdbc.backup.allFlag}")
	  private String allFlag;
	  
	  @Value("${jdbc.backup.home}")
	  private String backupHome;
	  
	  private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

	  private final String SPRIT = "\\";

	  private final String COMMA = ",";

	  @PostConstruct
	  private void init() {
	    this.userPass = ((String)EncryptablePropertyPlaceholderConfigurer.getContextProperty("jdbc.trader.password"));
	  }

	  public String dbFullBackup(String directoryName)
	  {
	    Map backupMap = buildBackupCmd(directoryName);
	    String cmd = (String)backupMap.get("cmd");
	    if (run(cmd)) {
	      return (String)backupMap.get("log");
	    }
	    return null;
	  }
	  
	  public String dbPreduction(String fileName, String directoryName)
	  {
	    if (StringUtils.isEmpty(directoryName)) {
	      directoryName = this.backupDir;
	    }

	    Map preductionMap = buildPreductionCmd(fileName, directoryName);
	    String cmd = (String)preductionMap.get("cmd");
	    if (run(cmd)) {
	      return (String)preductionMap.get("log");
	    }

	    return null;
	  }

	  private boolean run(String cmd) {
	    Boolean isSuccess = Boolean.valueOf(false);
	    try {
	      Process process = Runtime.getRuntime().exec(cmd);
	      isSuccess = Boolean.valueOf(true);
	    } catch (Exception e) {
	      logger.error(e.getMessage());
	    }

	    return isSuccess.booleanValue();
	  }

	  private Map<String, String> buildBackupCmd(String directoryName) {
	    Map result = new HashMap();
	    String formatDate = this.sdf.format(new Date());

	    StringBuffer backupCmdStr = new StringBuffer();
	    backupCmdStr.append("expdp ").append(this.userName + "/" + this.userPass + "@" + this.serverAddr).append(" DIRECTORY=" + directoryName).append(" DUMPFILE=" + this.userName + formatDate + ".dmp ");

	    if ("true".equals(this.allFlag)) {
	      backupCmdStr.append(" FULL=Y ");
	    }
	    else {
	      backupCmdStr.append(" TABLES=(customer) ");
	    }
	    backupCmdStr.append(" LOGFILE=" + this.userName + formatDate + ".log ");

	    logger.info(backupCmdStr.toString());
	    result.put("errorCode", "0");
	    result.put("cmd", backupCmdStr.toString());
	    result.put("log", this.userName + formatDate + ".log");
	    return result;
	  }

	  private Map<String, String> buildPreductionCmd(String fileName, String directoryName) {
	    Map result = new HashMap();
	    String formatDate = this.sdf.format(new Date());
	    StringBuffer preductionCmdStr = new StringBuffer();
	    preductionCmdStr.append("impdp ").append(this.userName + "/" + this.userPass + "@" + this.serverAddr).append(" DIRECTORY=" + directoryName).append(" DUMPFILE=" + fileName).append(" LOGFILE=preduction" + formatDate + ".log ").append(" TABLE_EXISTS_ACTION=REPLACE ");

	    logger.info(preductionCmdStr.toString());
	    result.put("cmd", preductionCmdStr.toString());
	    result.put("log", "preduction" + formatDate + ".log");
	    return result;
	  }

	  public String getBackupFileNames(String directoryName)
	  {
		String fileNames = null;
	    String directoryPath = this.backupDir;
	    try
	    {
	      File file = new File("/hxapp/oracle/app/oracle/admin/orcl/dpdump/");
	      if (!file.isDirectory()) {
	        logger.info(directoryPath + " is not directory!");
	      } else {
	        logger.info(directoryPath + " is directory!");
	        String[] fileList = file.list();
	        for (int i = 0; i < fileList.length; i++) {
	          File readFile = new File(directoryPath + "\\" + fileList[i]);
	          if (!readFile.isDirectory()) {
	            logger.info("path=" + readFile.getPath() + ",name=" + readFile.getName());
	            if (StringUtils.isEmpty(fileNames))
	              fileNames = readFile.getName();
	            else
	              fileNames = fileNames + "," + readFile.getName();
	          }
	        }
	      }
	    }
	    catch (Exception e) {
	      logger.error(e.getMessage());
	    }
	    return fileNames;
	  }
	}
