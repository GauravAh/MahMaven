package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Objprop {
	
	String path = System.getProperty("user.dir") + "/ExFiles/Obj.properties";
	Properties properties;
	
	public Objprop() throws Exception{
		FileInputStream fileInputStream = new FileInputStream(path);
		properties = new Properties();
		properties.load(fileInputStream);
		
	}
	
	public String getUrl() {
		return properties.getProperty("Url");
	}

}
