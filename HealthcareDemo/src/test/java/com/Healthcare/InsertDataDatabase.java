package com.Healthcare;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class InsertDataDatabase {

	static Properties prop=new Properties();
	public static void main(String[] args) {
		try {
			File src=new File("./Config/Config.properties");
			FileInputStream fis=new FileInputStream(src);
			prop.load(fis);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			Statement stmt=con.createStatement();		
			String var=prop.getProperty("State");
			String var1=prop.getProperty("Name");
			String var2=prop.getProperty("EmailAddress");
			String var3=prop.getProperty("Mobile");
			String var4=prop.getProperty("Password");
			String var5=prop.getProperty("RePassword");
			String var6=prop.getProperty("Question");
			String var7=prop.getProperty("Answer");
			String sql="insert into demo values (Customer_Id.nextval,'"+var+"','"+var1+"','"+var2+"','"+var3+"','"+var4+"','"+var5+"','"+var6+"','"+var7+"')";
			//System.out.println(sql);
			String sql1="select * from demo";
			ResultSet rs=stmt.executeQuery(sql1);	
			while(rs.next())	
				System.out.println(rs.getInt(1)+" "+rs.getString(2)
				+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+
				rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	







