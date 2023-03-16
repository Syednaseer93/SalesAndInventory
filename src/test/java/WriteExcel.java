import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcel {


		public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
			Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Book7.xlsx"));
			for (int i = 0; i <= wb.getSheet("Sheet1").getLastRowNum(); i++) {
				for (int j = 0; j < wb.getSheet("Sheet1").getRow(0).getLastCellNum(); j++) {
					wb.getSheet("Sheet1").getRow(i).getCell(j).setCellValue("Nas");
					wb.write(new FileOutputStream("./data/Book8.xlsx"));
					
				}
			

			}
		}

	

}
