package com.firstProject;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Day10_ReadExcel {
    //    Import the apache poi dependency in your pom file
//    Create resources directory under project
//    Add the excel file on the resources folder
//    Create a new class : ReadExcel
//    Create a new test method : readExcel()
    @Test
    public void readExcel() throws IOException {
//        workbook > worksheet > row > cell
//    Store the path of the  file in a string
        String path = "src/main/resources/Capitals.xlsx";
//    Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//    Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//    Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");
//        workbook.getSheetAt(0);//ALTERNATIVE
//    Go to first row
        Row row1 = sheet1.getRow(0);
//    Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println("ROW1 CELL1  = "+cell1);
        String cell1String = cell1.toString();
        System.out.println("ROW1 CELL1 AS STRING = "+cell1String);
//    Go to second cell on that first row and print
        String row1Cell2 = sheet1.getRow(0).getCell(1).toString();//CHAINING THE METHODS
        System.out.println("ROW1 CELL2 : "+row1Cell2);
        Assert.assertTrue(row1Cell2.equals("CAPITAL"));
//    Go to 2nd row 1st cell  and assert if the data equal to USA
        String row2Cell1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("EXPECTED IS NOT EQUAL TO USA","USA",row2Cell1);
//    Go to 3rd row 2nd cell-chain the row and cell
        String row3Cell2=sheet1.getRow(2).getCell(1).toString();
        System.out.println("ROW3 CELL2 : "+row3Cell2);
//    Find the number of row
        int totalRowCount = sheet1.getLastRowNum()+1;//index starts at 0
        System.out.println("Total Row Count : "+totalRowCount);
//    Find the number of used row
        int usedRowCount = sheet1.getPhysicalNumberOfRows();//index starts at 1
        System.out.println("Used Row Count : "+usedRowCount);
    /*
       HOMEWORK : Print country, capitol key value pairs as map object()
        create a map
        then use a loop to add key value pains in the map
        use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
         */
    }
}
