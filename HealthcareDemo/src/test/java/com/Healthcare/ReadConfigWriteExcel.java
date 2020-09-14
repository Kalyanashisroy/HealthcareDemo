package com.Healthcare;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadConfigWriteExcel {
	static Properties prop=new Properties();
	static XSSFCell Cell;
	static XSSFRow Row;
	public static void main(String[] args) {
		try {
			File src=new File("./Config/Config.properties");
			FileInputStream fis=new FileInputStream(src);
			prop.load(fis);
			System.out.println(prop.getProperty("EmailAddress").toUpperCase());
			System.out.println("Email Address:"+validateEmail(prop.getProperty("EmailAddress")));
			System.out.println(prop.getProperty("MobileNumber"));
/*			String email1="kr.kgec@gmail.com";
			String email2="krkgecgmail.com";
			System.out.println("email1 = "+validateEmail(email1));
			System.out.println("email2 = "+validateEmail(email2));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// permanent counter for excel row to read --start
			int counter;
			File srccounter=new File("./Config/per_row_counter.properties");
			FileInputStream fiscounter=new FileInputStream(srccounter);
			Properties propcount=new Properties();
			propcount.load(fiscounter);
			System.out.println(propcount.getProperty("excelrowcount"));
			String getcounter=propcount.getProperty("excelrowcount");
			int getcounter1 = Integer.parseInt(getcounter);
			//	permanent counter for excel row to read --end
			File src=new File("./TestData/DataExcel.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("Sheet9");
			int rownum =getcounter1 -1;
			//XSSFCell Cell;
			//XSSFRow Row;
			Row = sheet.createRow(rownum);
			cellentry(0,"State");
			cellentry1(1,"Name");
			cellentry(2,"EmailAddress");
			cellentry(3,"MobileNumber");
			cellentry(4,"Password");
			FileOutputStream fos=new FileOutputStream(src);
			wb.write(fos);
			wb.close();
			fos.close();
			//permanent counter for excel row to WRITE --start
			counter=getcounter1 + 1;
			String count2 = Integer.toString(counter);
			propcount.setProperty("excelrowcount",count2);
			FileOutputStream frcount = new FileOutputStream(srccounter);
			propcount.store(frcount,"Properties");
			frcount.close();
			//permanent counter for excel row to WRITE --start
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void cellentry(int col,String parameter) {
		Cell = Row.getCell(col,org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
		if(Cell == null) {
			Cell = Row.createCell(col);
			Cell.setCellValue(prop.getProperty(parameter));
		}else {
			Cell.setCellValue(prop.getProperty(parameter));
		}
	}
	static void cellentry1(int col,String parameter) {
		Cell = Row.getCell(col,org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
		if(Cell == null) {
			Cell = Row.createCell(col);
			Cell.setCellValue(prop.getProperty(parameter).toUpperCase());
		}else {
			Cell.setCellValue(prop.getProperty(parameter).toUpperCase());
		}
	}
	public static String validateEmail(String email) {
		/*if(email==null||email.isEmpty()) {
			return "Invalid";
		}*/
		String emailRegex="^[a-zA-Z0-9_+&*-]+"
				+ "(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+
				"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern=Pattern.compile(emailRegex);
		if(pattern.matcher(email).matches()) {
			return "Valid";
		}else {
			return "Invalid";
		}
	}
}
