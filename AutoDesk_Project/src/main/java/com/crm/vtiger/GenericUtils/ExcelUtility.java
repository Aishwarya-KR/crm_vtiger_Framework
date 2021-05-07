package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class contains methods for reading the data in excel sheet
 * @Aishwarya
 */

public class ExcelUtility {
	/*
	 * This method used to read from excel by specifying sheetname, row number, and cell number
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return cell string value
	 * @throws throwable
	 */
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook=WorkbookFactory.create(file);
	    Sheet sheet=workbook.getSheet(sheetName);
	    Row row=sheet.getRow(rownum);
	    Cell cell=row.getCell(cellnum);
	    return cell.getStringCellValue();
	    
		
	}
	
	/*
	 * This method return all the data in the sheet
	 * @param sheetName
	 * @return data
	 * @throws Throwable
	 */
	
	public Object[][] getExcelData(String sheetName)throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
		 for(int j=0;j<lastCell;j++) {
			 data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
		 }
		}
		return data;
	}
	
	public String getExcelData(String sheetName,String tcID,String headerValue) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int expectedRow=0;
		for(int i=0;i<=lastRow;i++)
		{
			String testCaseID=sheet.getRow(i).getCell(0).getStringCellValue();
			if(testCaseID.equalsIgnoreCase(tcID))
			{
				expectedRow=i;
				break;
			}
		}
		expectedRow--;
		int expectedColumn=0;
		int lastCell=sheet.getRow(expectedRow).getLastCellNum();
		for(int j=0;j<lastCell;j++)
		{
			String value=sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if(value.equalsIgnoreCase(headerValue))
			{
				expectedColumn=j;
				break;
			}
		}
		return sheet.getRow(expectedRow+1).getCell(expectedColumn).getStringCellValue();	
		
	}
	/*
	 * This method used to write data inside the excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws Throwable
	 */

	public void writeExcelData(String sheetname,int rownum,int column,String value)throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook workbook=WorkbookFactory.create(file);
		workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writeFile=new FileOutputStream(IPathConstant.EXCEL_FILEPATH);
		workbook.write(writeFile);
	}
	

}
