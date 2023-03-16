import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Book7.xlsx"));
		for (int i = 0; i <= wb.getSheet("Sheet1").getLastRowNum(); i++) {
			for (int j = 0; j < wb.getSheet("Sheet1").getRow(0).getLastCellNum(); j++) {
				String v = wb.getSheet("Sheet1").getRow(i).getCell(j).toString();
				System.out.print(v+" ");
			}
			System.out.println();

		}
	}

}
