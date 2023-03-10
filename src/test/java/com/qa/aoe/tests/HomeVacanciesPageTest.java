package com.qa.aoe.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.aoe.base.BaseTest;
import com.qa.aoe.constants.AppConstants;

public class HomeVacanciesPageTest extends BaseTest {

	@Test(priority = 1)
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}

	@Test(priority = 3)
	public void acceptCookiesPopup() {
		homePage.acceptCookiesPopUp();
	}


	@Test(priority = 4)
	public void vacanciesPageNavigationTest() throws InterruptedException {
		vacanciesPage = homePage.navigateToVacanciesPage();
		String actVacanciesPageTitle = vacanciesPage.getVacanciesPageTitle();
		System.out.println("page act title: " + actVacanciesPageTitle);
		Assert.assertEquals(actVacanciesPageTitle, AppConstants.VACANCIES_PAGE_TITLE);
		
	}
	
	@Test(priority = 5)
	public void filterOnVacanciesPage() {
		
		vacanciesPage.dofilter("Frontend");
		String actkeywordInPageTitle = vacanciesPage.getkeywordInPageTitle();
		System.out.println("page act title: " + actkeywordInPageTitle);
		Assert.assertEquals(actkeywordInPageTitle, AppConstants.KEYWORD_IN_PAGE_TITLE);
		
		
	}

}
