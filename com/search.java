package com;


/**
 * Created by luchik on 03.06.15.
 */
//import org.apache.xpath.operations.String;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

        import java.util.List;
        import java.util.concurrent.TimeUnit;
        import org.openqa.selenium.*;

public class search extends page{

    public search(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="price[min]") private  WebElement text_min;
    @FindBy(id="price[max]") private  WebElement text_max;
    @FindBy(id="submitprice") private  WebElement botton_click;
    // private  WebElement resultStats;
    @FindBy(className="g-i-more-link-text") private  WebElement next;
    @FindBy(className="g-i-tile g-i-tile-catalogt") private  WebElement comp1;
    @FindBy(className="g-price-uah") private  WebElement price;


    //        boolean est;
    public result search(String searchStatement,String searchStatement2){
        text_min.click();
        text_min.clear();
        text_min.sendKeys(searchStatement);

        text_max.click();
        text_max.clear();
        text_max.sendKeys(searchStatement2);

        botton_click.click();

        boolean est;
        do {
            est = false;
            try {
                if (next.getText().matches("^[\\s\\S]*Показать[\\s\\S]*$")) {
                    est = true;
                    next.click();
                }

               else{
                    break;
                }
            } catch (Exception e) {
            }
        }
        while (est);


        List<WebElement> comp = _driver.findElements(By.xpath("//div[@id='block_with_goods']/div[1]/div[@class='g-i-tile g-i-tile-catalog']"));
        //System.out.println("comp:" + comp.size());


        String dataAll=_driver.findElement(By.xpath("//div[@id='title_page']/div/div/div[3]/ul/li[3]/p")).getText();
        String[] dataMas =  dataAll.trim().split("\\s+");
        String dataSts=dataMas[1];
        int dataInt = Integer.parseInt(dataSts);

        if (comp.size()==dataInt){
            System.out.println("test1 projden- kolvo elementov yf stranice sovpadaet c kol v spiske i ravno"+comp.size());
        }

        List<WebElement> pr = _driver.findElements(By.className("g-price-uah"));
        //System.out.println("price1:" + pr.size());
        int y=0;
        for (int i=0;i<pr.size();i++){
            String t = pr.get(i).getText();
            String yy = t.replace("грн.", "");
            String str = yy.replaceAll("[^\\d.]", "");
            int t2 = Integer.parseInt(str);

            //System.out.println("price2="+t2);
            int min=Integer.parseInt(searchStatement);
            int max=Integer.parseInt(searchStatement2);

           int maxNew= 121712;
            if ((t2>=min)||(t2<=maxNew)){
                y++;
            }
            if (y==comp.size()){
                System.out.println("test 2 projden-vse tovaru nyznoj cenu");

            }
        }
        //System.out.println("y"+y);
        //System.out.println("string"+dataMas[1]);
        _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement my = _driver.findElement(By.className("filter-active"));

        return PageFactory.initElements(_driver, result.class);
    }


}