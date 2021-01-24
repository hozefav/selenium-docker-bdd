package com.stepdefs;

import com.searchmodule.pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchSteps {

    private WebDriver driver;
    private SearchPage searchPage;

    @Given("I am on the website duck-duck-go")
    public void i_am_on_the_website_duck_duck_go(){
        searchPage = new SearchPage(driver);
        searchPage.goTo();
        //throw new io.cucumber.java.PendingException();
    }

    @And("I enter the {string} to search")
    public void iEnterTheToSearch(String arg0) {
        searchPage.doSearch(arg0);
    }

    @And("I navigate to videos search")
    public void iNavigateToVideosSearch() {
        searchPage.goToVideos();
    }

    @Then("I should get minimum {int} search results")
    public void iShouldGetMinimumSearchResults(int min) {
        int size = searchPage.getResult();
        Assert.assertTrue(size > min);
    }

    @Before
    public void setupDriver() throws MalformedURLException {
        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }
        else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

    }

    @After
    public void quitBrowser(){
        this.driver.quit();
    }
}
