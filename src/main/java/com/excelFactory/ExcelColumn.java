package com.excelFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelColumn {

	public static List<String> columnValue(String path,int columnNumber) throws Throwable {
		//location/path 
		
		
		//java
		FileInputStream fs= new FileInputStream(path);// 1st 
		
		//Apache POI
		XSSFWorkbook workbook=new XSSFWorkbook(fs);//1) workbook
		XSSFSheet sheet= workbook.getSheetAt(0);//2)worksheet
		List<String> myList= new ArrayList<String>();//List ==>ArrayList
		//Array = object ==> []
		//String = data type or Class
		int RowCount= sheet.getPhysicalNumberOfRows();//3)allrow ******
		
		//System.out.println("Total Rows Number::"+ RowCount); 
		for(int rowindex=1;rowindex<RowCount;rowindex++) {//3)loop
			Row row=sheet.getRow(rowindex);
			//System.out.println("Total Column Number::"+ row.getPhysicalNumberOfCells());
			if (row!=null) {		
		for(int colmindex=0;colmindex<row.getLastCellNum();colmindex++) {	//4)all column & loop
			
			if(colmindex==columnNumber) {
				Cell cell=row.getCell(colmindex);//5)cell ==> data
				if(cell!=null) {				
					DataFormatter df= new DataFormatter();
					myList.add(df.formatCellValue(cell));
				}}}}}
		return myList;	
		
	}
	
	public static void main(String[] args) throws Throwable {
		String path = "./src/test/resources/Login Test data.xlsx";
		List<String> excelData =columnValue(path,1);
		System.out.println(excelData);
	}

}
