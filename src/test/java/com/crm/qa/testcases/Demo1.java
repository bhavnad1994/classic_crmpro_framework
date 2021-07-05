package com.crm.qa.testcases;

import com.crm.qa.utils.ExcelReader;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelReader excel = new ExcelReader();
		
		
		String sheetName = "contacts";
		excel.getTestData(sheetName);
		System.out.println("************8");
		excel.getTestData("EmployeeDetails");
		
		
		
		
		
	}

}
