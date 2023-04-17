//package com.test.utility;
//import java.util.ArrayList;
//import com.pega.uiframework.utils.Xls_Reader;
//public class TestUtil 
//{
//	static Xls_Reader reader;
//	public static ArrayList<Object[]> getDataFromExcel()
//	{
//		
//		ArrayList<Object[]> myData = new ArrayList<Object[]>();
//		try
//		{
//			reader =new Xls_Reader("C:\\Users\\Chetan Roman\\Desktop\\Excel file\\Registration_data.xlsx");
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		for(int rowcnt=2;rowcnt<=reader.getRowCount("Sheet1");rowcnt++)
//		{
//			String firstName=reader.getCellData("Sheet1", "Firstname\r\n"+ "", rowcnt);
//			String lastName=reader.getCellData("Sheet1", "Lastname\r\n"+ "", rowcnt);
//			String emailId=reader.getCellData("Sheet1", "EmailId\r\n"+ "", rowcnt);
//			String password=reader.getCellData("Sheet1", "Password\r\n"+ "", rowcnt);
//			
//			Object Ob[]= {firstName,lastName,emailId,password};
//			myData.add(Ob);
//			System.out.println(myData);
//		}
//		return myData;
//	}
//}
