package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropConfig {
	
	public static Properties prop;
	 static Logger log = Logger.getLogger(PropConfig.class.getName());
	public static Properties init_prop(String env)
	{
		
		log.info("Inside init_prop method");
		log.info("Env : " + env);
		String path = System.getProperty("user.dir");
		log.info("User Dir : " + path);
		String filePath="";
		if(env.equals("SIT"))
		{
		 filePath = path + "\\src\\main\\java\\config\\env_SIT.properties";
		 log.info("File Path : " + filePath);
		}
		else if (env.equals("UAT"))
		{
			filePath = path + "\\src\\main\\java\\config\\env_UAT.properties";
			 log.info("File Path : " + filePath);
		}
		else
		{
		
			 log.error("Please provide correct Env Name [SIT,UAT]");
			System.out.println("Please provide correct Env Name [SIT,UAT]");
			System.exit(0);
		}
		File file = new File(filePath);
		 prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			log.info("Properties file loaded" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}
		
		return prop;

	}

}
