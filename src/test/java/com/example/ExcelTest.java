package com.example;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * excel 有03 07版本区别
 * Created by Elliot Ji on 2019/9/25.
 */
public class ExcelTest {

    @Test
    public void excelWrite03() throws Exception {
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建sheet
        HSSFSheet sheet = workbook.createSheet("First Workbook");

        //创建行
        HSSFRow row1 = sheet.createRow(0);

        //创建单元格
        HSSFCell cell1 = row1.createCell(0);

        //创建单元格内容
        cell1.setCellValue("我的第一次");

        FileOutputStream out = new FileOutputStream("d:/myFirstExcel03.xls");

        workbook.write(out);

        out.close();

    }

    @Test
    public void excelRead03() throws Exception {
        FileInputStream in = new FileInputStream("d:/myFirstExcel03.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(in);

        HSSFSheet sheetAt = workbook.getSheetAt(0);

        HSSFRow row = sheetAt.getRow(0);

        HSSFCell cell = row.getCell(0);

        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);

        in.close();
    }
}
