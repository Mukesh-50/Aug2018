package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.ConfigDataProvider;
import factory.DataProviderFactory;

public class TestConfigFile {

	
	@Test
	public void checkInstance()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		Assert.assertTrue(config.getStagingURL()!=null);
		Assert.assertEquals(config.getValue("randomKey"), "randomValue");
	}
	
	@Test
	public void checkInstance1()
	{
		Assert.assertTrue(DataProviderFactory.getConfig().getStagingURL()!=null);
		Assert.assertEquals(DataProviderFactory.getConfig().getValue("randomKey"), "randomValue");
	}
	
	
}
