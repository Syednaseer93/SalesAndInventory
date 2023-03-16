import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPractice {

	public static void main(String[] args) {

		/*try {
			Workbook wb = WorkbookFactory.create(new FileInputStream("./data/logindata.xlsx"));
			String cellValue = wb.getSheet("sheet1").getRow(1).getCell(1).getStringCellValue().toString();
			System.out.println(cellValue);
		} catch (Exception e) {
		}
		
		 * try { Workbook wb = WorkbookFactory.create(new
		 * FileInputStream("./data/logindata.xlsx"));
		 * wb.getSheet("Sheet1").getRow(1).createCell(1).setCellValue("sunil");
		 * wb.write(new FileOutputStream("./data/logindata.xlsx"));
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream("./data/logindata.xlsx"));
			int lastRowNum = wb.getSheet("sheet1").getLastRowNum();
			System.out.println(lastRowNum);
		} catch (Exception e) {
		}
		
		 * try { Workbook wb = WorkbookFactory.create(new
		 * FileInputStream("./data/multipleRead.xlsx")); for(int
		 * i=0;i<=wb.getSheet("sheet1").getLastRowNum();i++) { String col1 =
		 * wb.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue(); String col2
		 * = wb.getSheet("sheet1").getRow(i).getCell(1).getStringCellValue();
		 * System.out.println(col1+" | "+col2); }
		 * 
		 * } catch(Exception e) {
		 * 
		 * }
		 */

		try {

			Workbook wb = WorkbookFactory.create(new FileInputStream("./data/setdata.xlsx"));

			for (int i = 0; i < 6; i++) {
				 List<String> list = Arrays.asList("Syed", "Vivek", "Nayeem", "Rajeev","Santosh", "Raja");
				//String[] arr = { "Syed", "Vivek", "Raju", "nayeem", "roshan", "santosh" };
				wb.getSheet("sheet1").getRow(i).createCell(13).setCellValue(list.get(i));
				wb.getSheet("sheet1").getRow(i).createCell(14).setCellValue(list.get(i));
				wb.write(new FileOutputStream("./data/setdata.xlsx"));
				wb.close();
			}
		} catch (Exception e) {

		}
		
		

	}

}
