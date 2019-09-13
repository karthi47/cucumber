package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Base {
	public static Object[][] getData() throws Throwable {
		File loc = new File("C:\\Users\\Karthik durai\\eclipse-workspace\\Facebook1\\excel\\Demo.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		String name = null;
		Row headerRow = s.getRow(0);
		Object[][] obj = new Object[s.getPhysicalNumberOfRows() - 1][headerRow.getPhysicalNumberOfCells()];
		for (int i = 1; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int type = c.getCellType();
				if (type == 1) {
					name = c.getStringCellValue();
				}
				if (type == 0) {
					if (DateUtil.isCellDateFormatted(c)) {
						Date date = c.getDateCellValue();
						SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yy");
						fr.format(date);
					} else {

						double d = c.getNumericCellValue();
						long l = (long) d;
						name = String.valueOf(l);
					}

				}
				obj[i - 1][j] = name;
			}

		}

		return obj;
	}
}
