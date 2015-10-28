package com;



/**
 * Created by luchik on 03.06.15.
 */
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.PageFactory;

public class run {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        //baseUrl = "http://rozetka.com.ua/";
        driver.get("http://rozetka.com.ua/notebooks/c80004/filter/");
        //driver.get(baseUrl + "/notebooks/c80004/filter/");
        search bingHome = PageFactory.initElements(driver, search.class);
        String min="50000";
        String max="150000";
        result searchResults = bingHome.search("50000","150000");
        System.out.println(searchResults.getPagesReturned());
        driver.close();
    }
}

