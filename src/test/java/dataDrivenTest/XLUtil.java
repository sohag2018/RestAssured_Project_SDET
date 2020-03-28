package dataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtil {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		int rowCount=ws.getLastRowNum();
		
		return rowCount;
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		
		return cellCount;
		
	}
	
	
	public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
	}
	
	
	
	
	

}
 