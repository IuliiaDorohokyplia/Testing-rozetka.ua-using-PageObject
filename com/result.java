package com;



import org.openqa.selenium.support.FindBy;

/**
 * Created by luchik on 03.06.15.
 */

//import org.apache.xpath.operations.String;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class result extends page {

    public result(WebDriver driver) {
        super(driver);
    }

    // private WebElement b_tween;//rezults

    @FindBy(className="filter-active") private  WebElement text_search;
   // private WebElement resultStats;//rezults

    public String getPagesReturned(){
        return text_search.getText();
    }
}
