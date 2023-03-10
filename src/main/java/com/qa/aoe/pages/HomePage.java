package com.qa.aoe.pages;

import com.microsoft.playwright.Page;


public class HomePage {

	private Page page;


	// 1. String Locators - OR
	private String aoeLogo = "//a[@data-qa='header_logo']";
	private String careerLink = "//a[text()='Karriere']";
	private String vacanciesLink = "//a[@class='color-secondary'][normalize-space()='Stellenangebote']"; 
    private String cookiesOkButton = "//button[@id='onetrust-accept-btn-handler']";
	

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}
	
     // 4. get home page URL
	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}

	
     // 5. click on ok button for accept cookies

	   public void acceptCookiesPopUp()
	   {
		   page.click(cookiesOkButton);
	   }
	
     // 6. navigate to vacancies pages
	public VacanciesPage navigateToVacanciesPage() throws InterruptedException  {
	 
    	page.hover(careerLink);
		page.waitForSelector(vacanciesLink).isVisible();
		page.click(vacanciesLink);
		return new VacanciesPage(page);
	}



}
