package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExelFileReaderLogicUtility {
    private static Workbook workbook;
    private static Sheet sheet;

    public static Object[][] getTestData(String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\UserformDetails.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        
       
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
          System.out.println(rowCount);
        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip headers
            Row row = sheet.getRow(i); // Get the row
            if (row == null) { // Skip null rows
                continue;
            }
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j); // Get the cell
                if (cell == null) { // Handle null cells
                    data[i - 1][j] = "ddd"; // Assign empty string for null cells
                } else {
                    data[i - 1][j] = cell.toString();
                }
            }
        }
        workbook.close();
        return data;
    }
  }



