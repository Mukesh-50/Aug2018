package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import factory.DataProviderFactory;

public class TestExcelFile {

	@Test
	public void checkInstance()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		Assert.assertTrue(excel.getStringData(0, 0, 0)!=null);
	}
	
	@Test
	public void checkInstance1()
	{
		Assert.assertTrue(DataProviderFactory.getExcel().getStringData(0, 0, 0)!=null);
	}
	
}
