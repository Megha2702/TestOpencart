package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public static String getCellValue(String xl, String Sheet, int row, int col) {
			try {
            FileInputStream file = new FileInputStream(xl);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFCell cell = workbook.getSheet(Sheet).getRow(row).getCell(col);
            
            if(cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else {
                return cell.getRawValue();
            }
            
        } catch(Exception e) {
            return "";
        }
	}

	public static int getRowCount(String xl, String Sheet)  {
		try {
            FileInputStream file = new FileInputStream(xl);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            return workbook.getSheet(Sheet).getLastRowNum();
            
        } catch(Exception e) {
            return 0;
        }
}
}

