package com.excelFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ExcelReadWithJsonArray {

	public static List<String> ExcelManager(String path, String sheetName, String ColumnName) throws Throwable {

		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		List<String> columnName = new ArrayList<String>();

		JsonObject jsonWorkBookObject = new JsonObject();
		JsonArray jsonsheetArray = new JsonArray();
		JsonObject jsonRowObject = new JsonObject();

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			Sheet sheet = workbook.getSheetAt(i);

			
			System.out.println("Sheet found = "+sheet.getSheetName());
			System.out.println("Total Rows Number::"+ sheet.getPhysicalNumberOfRows());
			for (int r =0; r < sheet.getPhysicalNumberOfRows(); r++) {
				Row row = sheet.getRow(i);
				System.out.println(">>>>>>>>>"+row.getCell(r));
				System.out.println("Total Column Number::" + row.getLastCellNum());
				//if ( r == 0) {
					
					 columnName.add(row.getCell(r).getStringCellValue());
					System.out.println("Column Header :: "+row.getCell(r).getStringCellValue());
					
				
				//}
				System.out.println("Row number ::" + r);
				//if ( r != 0) {
					for (int c = 0; c <row.getLastCellNum(); c++) {
						
						Cell cell = row.getCell(c);
//						if(c==1) {
//							cell=row.getCell(r);
//							if(cell!=null) {				
//								DataFormatter df= new DataFormatter();
//								System.out.println(".......>>"+df.formatCellValue(cell));
//							}
//							}
						if (cell != null) {
							DataFormatter df = new DataFormatter();
							jsonRowObject.addProperty(columnName.get(c), df.formatCellValue(cell));
							System.out.println(jsonRowObject);
							System.out.println( row.getCell(c).getStringCellValue());
						}
					}
				//}
			jsonsheetArray.add(jsonRowObject);
			}
			jsonWorkBookObject.add(workbook.getSheetName(i), jsonsheetArray);
		}

		JSONObject jsonObject = new JSONObject(jsonWorkBookObject.toString());
		JSONArray sheetData = jsonObject.getJSONArray(sheetName);
		List<String> columnData = new LinkedList<>();

		for (int i = 0; i < sheetData.length(); i++) {
			JSONObject eachRowData = sheetData.getJSONObject(i);
			columnData.add(eachRowData.get(ColumnName).toString());

		}
		
		return columnData;

	}

	public static void main(String[] args) throws Throwable {
		String path = "./TestData/ConfigData.xlsx";

		System.out.println(ExcelReadWithJsonArray.ExcelManager(path, "Orbis", "Value"));
	}

}
