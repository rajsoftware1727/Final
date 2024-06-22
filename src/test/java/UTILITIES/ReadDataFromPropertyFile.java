package UTILITIES;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static Object readDataFromProperty(String key) throws IOException
	{
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/PropertyFile/PropertiesFile");
		Properties p=new Properties();
		p.load(fi);
		return p.getProperty(key);
	}
	
 	

}
