package UTILITIES;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	static FileInputStream fi;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow currentRow;
	static XSSFCell currentCell;
	static DataFormatter dataformatter;
 	
	public static int  getRowCount(String path,String sheetName) throws IOException
	{
		  fi=new FileInputStream(path);
		  workbook=new XSSFWorkbook(fi);
		  sheet=workbook.getSheet(sheetName);
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int  getCellCount(String path,String sheetName,int rowNo) throws IOException
	{
		  fi=new FileInputStream(path);
		  workbook=new XSSFWorkbook(fi);
		  sheet=workbook.getSheet(sheetName);
		  currentRow=sheet.getRow(rowNo);
		return currentRow.getPhysicalNumberOfCells();
	}
	
   public static Object getCellData(String path,String sheetName,int rowNo,int cellNo) throws IOException
   {
	     fi=new FileInputStream(path);
		  workbook=new XSSFWorkbook(fi);
		  sheet=workbook.getSheet(sheetName);
		  currentRow=sheet.getRow(rowNo);
		  currentCell=currentRow.getCell(cellNo);
		  dataformatter=new DataFormatter();
		workbook.close();
		fi.close();
		return dataformatter.formatCellValue(currentCell).trim();
    }
}
