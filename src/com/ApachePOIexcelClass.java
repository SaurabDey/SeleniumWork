package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIexcelClass {

	public static void main(String[] args) throws Exception 
	{
		
		File f= new File("Resource/Apache.xlsx");// for .xls format file use HSSFWorkbook
		
		//--------------Read excel-----------------------------------------------------
		FileInputStream fis= new FileInputStream(f);
		
		XSSFWorkbook excel= new XSSFWorkbook(fis); //HSSFWorkbook
		
		XSSFSheet sheet= excel.getSheet("Sheet1");
		
		String title=sheet.getRow(0).getCell(0).getStringCellValue();

		String title2=sheet.getRow(0).getCell(1).getStringCellValue();
		

		String title3=sheet.getRow(0).getCell(2).getStringCellValue();
		
		DataFormatter formatter = new DataFormatter();// to be used when we have number and we want to 
		Cell cell=sheet.getRow(1).getCell(2);//read numeric strings in Excel cells as string (not numbers) with Apache POI
		String numberastext=formatter.formatCellValue(cell);// or else we get error "Cannot get a STRING value from a NUMERIC cell"
		
		
		System.out.println(title +" "+title2+" "+title3+" "+numberastext);
		
		int noOfRows=sheet.getLastRowNum();
				
		for (int i = 1; i <= noOfRows; i++) 
		{
			
			title=sheet.getRow(i).getCell(0).getStringCellValue();

			title2=sheet.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println(title +" "+title2);
		}
		
		
		//-------------Write excel----------------------
		

		//------------------write--------------	
			sheet.createRow(11).createCell(2).setCellValue("Pass");
			
			sheet.createRow(11).createCell(3).setCellValue("Fail");
			
			FileOutputStream fos=new FileOutputStream(f);
			
			excel.write(fos);
		//------------------write--------------	
		
		excel.close();
		
		System.out.println("Write Successful");
	}

}
