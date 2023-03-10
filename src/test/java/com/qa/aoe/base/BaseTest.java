package com.qa.aoe.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.aoe.factory.PlaywrightFactory;
import com.qa.aoe.pages.HomePage;
import com.qa.aoe.pages.VacanciesPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected VacanciesPage vacanciesPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
