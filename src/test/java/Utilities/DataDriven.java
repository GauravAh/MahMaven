package Utilities;

import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	String filepath;
	
	public DataDriven(String filepath){
		this.filepath=filepath;
	}
	
	public HashMap<String, String> readHashmap(String Excelname) throws Exception {
		workbook = new XSSFWorkbook(filepath);
		sheet= workbook.getSheet(Excelname);
		int rows = sheet.getLastRowNum();
		HashMap<String, String> mmap = new HashMap<String, String>();
		for(int i=0;i<=rows;i++) {
			String nkeys = sheet.getRow(i).getCell(0).getStringCellValue();
			String nValue = sheet.getRow(i).getCell(1).getStringCellValue();
			mmap.put(nkeys, nValue);
		}
		return mmap;
	}

}
