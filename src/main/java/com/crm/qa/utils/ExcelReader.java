package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.crm.qa.base.TestParent;

public class ExcelReader extends TestParent {
	
	public static String TESTDATA_SHEET_PATH = "/ClassicCRMPro/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int columnCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Excel sheet has " + rowCount +" rows and " + columnCount + " columns" );
		
		Object[][] data = new Object[rowCount-1][columnCount];
		
		for (int i = 0; i < rowCount-1; i++) {
			for (int k = 0; k < columnCount; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k] + "   " );
			}
		}
		return data;
	}

}
