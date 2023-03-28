package com.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {
    public static  Object[][] getData(String excelPath,String sheetName) throws IOException {
        try{
            int rowIndex=0, colIndex=0;
            FileInputStream file = new FileInputStream(excelPath);
            XSSFWorkbook  workbook = new XSSFWorkbook(file);
            XSSFSheet sheet= workbook.getSheet(sheetName);
            Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            Iterator<Row> rowIterator=sheet.iterator();
            Row row =rowIterator.next();
            while(rowIterator.hasNext()){
                row =rowIterator.next();
                Iterator<Cell> cellIterator =row.iterator();
                while(cellIterator.hasNext()){
                    Cell cell =cellIterator.next();
                    switch (cell.getCellType()){
                        case NUMERIC :
                            data[rowIndex][colIndex]=(int)cell.getNumericCellValue();
                            break;

                        case STRING:
                            if(cell.getStringCellValue() .equals("null")){
                                data[rowIndex][colIndex]=null;
                            }
                            else{
                                data[rowIndex][colIndex]=cell.getStringCellValue();
                            }
                            break;
                        case BOOLEAN:
                            data[rowIndex][colIndex]=cell.getBooleanCellValue();
                            break;

                        case BLANK:
                            data[rowIndex][colIndex]=null;
                            break;
                    }
                    colIndex += 1;
                }
                rowIndex += 1;
                colIndex=0;
            }
            file.close();
            return  data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
