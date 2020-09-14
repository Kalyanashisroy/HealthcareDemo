package Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		File src=new File("./TestData/DataExcel.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(6);
		int rowcount=sheet.getLastRowNum();
		System.out.println("Total rows is "+(rowcount+1));
		for(int i=0;i<rowcount;i++) {
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from row"+i+" is " + data);
			
		}
		for(int i=0;i<rowcount;i++) {
			String data0=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Data from row"+i+" is " + data0);
		}
		wb.close();
	}

}
