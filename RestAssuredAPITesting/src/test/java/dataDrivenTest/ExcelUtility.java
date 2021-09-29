package dataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String file, String sheet) throws IOException {
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		System.out.println("row count is: " + rowCount);
		return rowCount;
	}

	public static int getCellCount(String file, String sheet, int rownum) throws IOException {
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		System.out.println("column count is: " + cellCount);
		return cellCount;
	}

	public static String getCellData(String file, String sheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		System.out.println("data returned is: " + data);
		return data;
	}

}
