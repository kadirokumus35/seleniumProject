package com.practices.practice05;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q05_Excel_EarningList {
   /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the earnings amount(Natural Order).
    Then
        Assert that row number of Wednesday is 1
     */


    @Test
    public void excel_EarningList() throws IOException {
        String path = "src/main/resources/EarningList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        //Put all earnings into a list
        List<Double> earningList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            earningList.add(Double.valueOf(sheet.getRow(i).getCell(1).toString()));

        }

        System.out.println("earningList = " + earningList);

        List<Double> earningListSorted = new ArrayList<>(earningList);
        Collections.sort(earningListSorted);
        Collections.reverse(earningListSorted);
        System.out.println("earningListSorted = " + earningListSorted);

        for (int i = 0; i < earningList.size(); i++) {
            for (int j = 0; j < earningList.size(); j++) {

                if (earningList.get(i) == earningListSorted.get(j)) {

                    sheet.getRow(i + 1).createCell(2).setCellValue(j + 1);

                }
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}