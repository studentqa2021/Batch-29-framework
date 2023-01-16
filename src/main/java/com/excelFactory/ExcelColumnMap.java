package com.excelFactory;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelColumnMap {

	public static String columnValueMap(String path,String key) throws Throwable
    {
		
		FileInputStream file= new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheetAt(0);
		Map<String,String> mymap= new HashMap<>();
		int RowCount= sheet.getPhysicalNumberOfRows();
		
		//System.out.println("Total Rows Number::"+ RowCount); 
		for(int rowindex=1;rowindex<RowCount;rowindex++) {
			Row row=sheet.getRow(rowindex);
			//System.out.println("Total Column Number::"+ row.getPhysicalNumberOfCells());
			if (row!=null) {		
		for(int colmindex=0;colmindex<row.getLastCellNum();colmindex++) {	
			
				Cell cell=row.getCell(colmindex);
				if(cell!=null) {				
					DataFormatter df= new DataFormatter();
					
					mymap.put(df.formatCellValue(row.getCell(0)),df.formatCellValue(row.getCell(1)));
				}}}}
		return mymap.get(key);	
		
	}
	
	public static void main(String[] args) throws Throwable {
		
		String path = "./src/test/resources/Login Test data.xlsx";

		System.out.println(ExcelColumnMap.columnValueMap(path,"USER_NAME"));
		System.out.println(ExcelColumnMap.columnValueMap(path,"PASSWORD"));
		System.out.println(ExcelColumnMap.columnValueMap(path,"STATUS"));

	
	}

}
