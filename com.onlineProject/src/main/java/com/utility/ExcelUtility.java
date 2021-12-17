package com.utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility {

	static FileInputStream fis = null;
	static Workbook wb = null;
	static Sheet sh = null;

	public static String getCellData(String filepath, String name, int rownum, int column) {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(name);
		Cell c = sh.getRow(rownum).getCell(column);

		return df.formatCellValue(c);

	}

	@Test
	public void test() {
	//	String xlpath = System.getProperty("user.dir") + "/src/test/resources/CoursesList.xls";
		String poipath = System.getProperty("user.dir") + "/src/test/resources/CoursesList.xlsx";

	//	System.out.println(getCellData(xlpath, "login", 0, 0));
		System.out.println(getCellData(poipath, "OperatorPage", 0, 0));
	}

	public static ArrayList<String> readDataOfColUsingPoi(String fileName, String sheetName, int colNo) {
		ArrayList<String> excelList = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(fileName);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();

		for (int i = 1; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(colNo);
			String text = df.formatCellValue(cell);
			System.out.println(text);

			excelList.add(text);
		}
		System.out.println(excelList);
		return excelList;
	}
	
		
	public static ArrayList<String> readDataOfRowUsingPoi(String fileName, String sheetName, int rowNo) {
		ArrayList<String> excelList = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(fileName);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);
		Row  row= sh.getRow(rowNo);
		int count =row.getLastCellNum();

		for (int i = 0; i <= count; i++) {
			Cell cell = sh.getRow(rowNo).getCell(i);
			String text = df.formatCellValue(cell);
			excelList.add(text);
		}
		System.out.println(excelList);
		return excelList;
	}
	
	@Test
	public void test2() {
	
		String poipath=System.getProperty("user.dir") + "/src/test/resources/CoursesList.xlsx";
		readDataOfRowUsingPoi(poipath, "UserPage", 2);
	}

	public static int getRowCount(String filepath, String name) {
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sh = wb.getSheet(name);
		int rowcount = sh.getLastRowNum();

		return rowcount;
	}

	public void getAllData(String filePath, String name) {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(name);
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int col = sh.getRow(i).getLastCellNum();
			for (int j = 0; j <= col; j++) {
				Cell c = sh.getRow(i).getCell(j);
				System.out.print(df.formatCellValue(c) + " ");
			}
			System.out.println();
		}
	}

	public String[][] getAllDataAsDP(String filePath, String name, int noOfParam) {
		String value = null;
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(name);
		int rows = sh.getLastRowNum();
		String data[][] = new String[rows][noOfParam];// 3,2
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < noOfParam; j++) {
				Cell c = sh.getRow(i).getCell(j);
				value = df.formatCellValue(c);
				data[i][j] = value;
			}
		}
		return data;
	}

}
