package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchTest extends BaseTest {
    private String keyWord;

    @BeforeTest
    @Parameters({"keyWord"})
    public void setUpParameters(String keyWord) {
        this.keyWord = keyWord;
    }

    @Test
    public void search(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(this.keyWord);
        searchPage.goToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);
    }

    @Test
    public void sayHello(){
        System.out.println("Hello folks!");
    }


}
