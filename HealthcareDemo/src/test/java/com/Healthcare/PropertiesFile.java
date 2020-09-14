package com.Healthcare;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesFile {
	static Properties prop=new Properties();
	public static void main(String[] args) {
		//readPropertiesFile();
		//writePropertiesFile();
	}
	public void readPropertiesFile() {
		
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
	}
	public static void writePropertiesFile() {
		
		try {
			File src=new File("./Config/Config.properties");
			FileOutputStream fos=new FileOutputStream(src);
			prop.setProperty("State", "West Bengal");
			prop.setProperty("Name", "KR");
			prop.setProperty("EmailAddress", "abc123");
			prop.setProperty("Password", "abc123");
			prop.setProperty("RePassword", "abc123");
			prop.setProperty("Question", "abc123");
			prop.setProperty("Answer", "abc123");
			prop.store(fos, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
