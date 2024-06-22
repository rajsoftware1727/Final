package UTILITIES;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 

 
public class DataProvider1 {
	String path;
	String sheetName;
	@DataProvider(name="v")
 	public String[][] provideData(Method m) throws IOException
	{
		if(m.getName().equalsIgnoreCase("Login_With_Valid_Input"))
		{
		     sheetName="validCredentials";

		}
 		path=System.getProperty("user.dir")+"/src/test/resources/TESTNGPROJECT.xlsx";
		String data[][]=null;
		int totalRows=ReadExcelData.getRowCount(path,sheetName);
		int totalColumns=ReadExcelData.getCellCount(path,sheetName, 1);
 		data=new String[totalRows-1][totalColumns];
		for(int row=1;row<totalRows;row++)
		{
			for(int column=0;column<totalColumns;column++)
			{
				data[row-1][column]=(String)ReadExcelData.getCellData(path,"validCredentials",row, column);
			}
		}
  		return data;
	}
	
	@Test(dataProvider="gg")
	public void getdata(String s[])
	{
		for(String g:s)
		{
			 
				System.out.println(g);
			
		}
		
	}

}
