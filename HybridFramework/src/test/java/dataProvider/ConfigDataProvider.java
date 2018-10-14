package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {


	Properties pro;
	
	public ConfigDataProvider()
	{
		pro=new Properties();
		try {
			pro.load(new FileInputStream(new File("./Configuration/config.properties")));
		} catch (IOException e) {
			System.out.println("Not able to read config file "+e.getMessage());
		}
	}
	
	
	public String getStagingURL()
	{
		return pro.getProperty("stagingURL");
	}
	
	public String getuatURL()
	{
		return pro.getProperty("uatURL");
	}
	
	public String getValue(String key)
	{
		return pro.getProperty(key);
	}
	
}
