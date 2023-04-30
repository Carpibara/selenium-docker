package searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "q")
    private WebElement searchTxt;

    @FindBy(linkText = "advanced search")
    private WebElement notFindLink;


    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://github.com/");
    }

    public void doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        //System.out.println(driver.getPageSource());
        this.searchTxt.sendKeys(keyword);
        this.searchTxt.sendKeys(Keys.ENTER);
        this.wait.until(ExpectedConditions.visibilityOf(this.notFindLink));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_button_homepage")));
        //this.searchBtn.click();

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_button_homepage")));
        //searchButton.click();
    }

    /*public void goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public void printResult() {
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println(this.allVideos.size());
    }*/
}
