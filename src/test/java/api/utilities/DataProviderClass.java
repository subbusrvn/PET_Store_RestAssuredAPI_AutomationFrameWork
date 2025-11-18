package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	//Get all the cell data value
	@DataProvider(name = "getAllData")
	public String[][] getallData() throws IOException {

		String path = System.getProperty("user.dir") + "\\testData\\Students_TestData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int rowcount = xl.getRowcount("Sheet1");
		int cellCount = xl.getCellcount("Sheet1", 1);

		String getAllData[][] = new String[rowcount][cellCount];

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 0; j < cellCount; j++) {

				getAllData[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}

		return getAllData;

	}
	
	//Get the cell data value
	
	@DataProvider(name = "getStudentID")
	public String[] rowData() throws IOException {
		
		String path = System.getProperty("user.dir")+"\\testData\\Students_TestData.xlsx";
		
		ExcelUtility xl= new ExcelUtility(path);
		int rowCount = xl.getRowcount("Sheet1");
		
		String rowCellData[] = new String[rowCount];
		for(int i= 1; i<=rowCount; i++) {
			
			rowCellData[i-1]= xl.getCellData("Sheet1", i,0);
		}
		return rowCellData;
		
		
	}
	
	

}
