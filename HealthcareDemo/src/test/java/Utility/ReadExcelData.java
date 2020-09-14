package Utility;

import com.Healthcare.PropertiesFile;

public class ReadExcelData extends PropertiesFile{

	public static void main(String[] args) {
		ExcelDataConfig excel=new ExcelDataConfig("D:\\Workspace\\HealthcareDemo\\TestData\\DataExcel.xlsx");
		//PropertiesFile pf=new PropertiesFile();
		//pf.readPropertiesFile();
		System.out.println(excel.getData(7, 0, 0));
		System.out.println(excel.getData(7, 0, 1));
		System.out.println(excel.getData(7, 0, 2));
		System.out.println(excel.getData(7, 0, 3));
		System.out.println(excel.getData(7, 0, 4));
		System.out.println(excel.getData(7, 0, 5));
		System.out.println(excel.getData(7, 0, 6));
	}

}
