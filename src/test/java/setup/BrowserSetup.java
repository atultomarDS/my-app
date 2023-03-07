package setup;

import helpers.BaseHelpers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BrowserSetup {
	BaseHelpers bs = new BaseHelpers();
	@BeforeMethod
	public void launch() {
		bs.chromeLaunch();
	}

	@AfterMethod
	public void appClose() {
		bs.tearDown();
	}
}
