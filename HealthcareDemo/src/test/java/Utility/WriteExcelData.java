package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.Healthcare.PropertiesFile;

public class WriteExcelData{
	static Properties prop=new Properties();
	public static void main(String[] args){
		try {
			try {
				File src=new File("./Config/Config.properties");
				FileInputStream fis=new FileInputStream(src);
				prop.load(fis);
				System.out.println(prop.getProperty("State"));
				System.out.println(prop.getProperty("Name"));
				System.out.println(prop.getProperty("EmailAddress"));
				System.out.println(prop.getProperty("Password"));
				System.out.println(prop.getProperty("RePassword"));
				System.out.println(prop.getProperty("Question"));
				System.out.println(prop.getProperty("Answer"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			File src=new File("./TestData/DataExcel.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(8);
			List<String> lstate=new ArrayList<String>();
			lstate.add("Mumbai");
			lstate.add("Pune");
			lstate.add("Panjab");
			lstate.add("Chennai");
			lstate.add("Gujrat");
			lstate.add("Bangalore");
			String var=prop.getProperty("State");
			String var1=prop.getProperty("Name");
			String var2=prop.getProperty("EmailAddress");
			String var3=prop.getProperty("Password");
			String var4=prop.getProperty("RePassword");
			String var5=prop.getProperty("Question");
			String var6=prop.getProperty("Answer");
			//int rowcount=sheet.getLastRowNum();
			//System.out.println("Total rows is "+(rowcount+1));
			for(int i=0;i<10;i++) {
			sheet.getRow(i).createCell(0).setCellValue(var);
			sheet.getRow(i).createCell(1).setCellValue(var1);
			sheet.getRow(i).createCell(2).setCellValue(var2);
			sheet.getRow(i).createCell(3).setCellValue(var3);
			sheet.getRow(i).createCell(4).setCellValue(var4);
			sheet.getRow(i).createCell(5).setCellValue(var5);
			sheet.getRow(i).createCell(6).setCellValue(var6);
			}
			/*String var_1=prop.getProperty("State");
			sheet.getRow(1).createCell(0).setCellValue(var_1);*/
			
			FileOutputStream fos=new FileOutputStream(src);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
