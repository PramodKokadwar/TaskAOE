package com.qa.aoe.pages;

import com.microsoft.playwright.Page;

import com.microsoft.playwright.Locator;




public class VacanciesPage {

	static Page page;

	// 1. String Locators - OR
	private String filterKeyword = "//input[@id='filter-keyword']";
	private String frontend ="a[data-qa='vacancies_table_AOE GmbH_4']";

	// 2. page constructor:
	public VacanciesPage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getVacanciesPageTitle() {
		return page.title();
	}

	// 3. page actions/methods:
	public String getkeywordInPageTitle() {
		return page.title();
	}


	public void dofilter(String keywords) {
		System.out.println("Search process "+ keywords);

		page.hover(filterKeyword);
		page.fill(filterKeyword, keywords);

		page.waitForTimeout(2000);
		page.click(frontend);
		
	}
}


