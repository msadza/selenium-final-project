import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class finalPro {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if (browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else{
            throw new Exception("Browser is not correct!");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Test
    public void test() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/");


        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]")).click();

        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[1]//a")).click();

        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("mzeko");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("sadza");
        driver.findElement(By.cssSelector("input#input-email")).sendKeys("sadzamzeko@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("598405807");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[type='radio'][name='newsletter'][value='1']")).click();
        //driver.findElement(By.cssSelector("input[type='radio'][name='newsletter'][value='0']")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
//        driver.findElement(By.cssSelector("input[class='btn btn-primary'][value='Continue']")).click();
        driver.findElement(By.className("btn-primary")).click();

        WebElement ele = driver.findElement(By.xpath("//*[@id=\"content\"]/p/a"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);

        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("sadzamzeko@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();


        // Move to 'Desktops' and select 'Show all Desktops'
        WebElement elem = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]"));
        Actions actions = new Actions(driver);
        Action mouseOverHome = actions
                .moveToElement(elem)
                .build();
        mouseOverHome.perform();
       //Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();

        //Choose 'MP3 Players' item
        driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[10]")).click();
        // - Move to 'iPod Classic' image and check that 'iPod Classic' text is visible on mouse hover
        WebElement tes = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[1]/a/img"));
        Action mouseOverHome2 = actions
                .moveToElement(tes)
                .build();
        mouseOverHome2.perform();


        try {
            System.out.println("araaa " + tes.getAttribute("alt"));


        } catch (ElementNotVisibleException e) {
            System.out.println("araliii");
        }

        // --     - Click on 'iPod Classic' link
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[1]/a")).click();
        //     - Click on first image and move on another images before text '4 of 4' is present (check Pic1)
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li[1]/a/img")).click();


        List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li"));
        System.out.println(allElements.size());

        WebElement imgTe = driver.findElement(By.xpath("//div[@class='mfp-counter']"));
        while (!imgTe.getText().equals("4 of 4")) {
            driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();

            System.out.println(imgTe.getText());

            WebDriverWait wait= new WebDriverWait(driver, 20);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/button[2]")));
        }
//        if (!imgTe.getText().equals("4 of 4")){
//            driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
//            Thread.sleep(1000);
//            imgTe=driver.findElement(By.xpath("//div[@class='mfp-counter']"));
//            System.out.println(imgTe.getText());
////            System.out.println(driver.findElement(By.xpath("//div[@class='mfp-counter']")).getText());
//        }else{
//            System.out.println("ukve aris 4 of 4");
//        }
//        for (int i=1; i<4;i++){
//            driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
//            Thread.sleep(1000);
//            System.out.println(driver.findElement(By.xpath("//div[@class='mfp-counter']")).getText());
//        }
//        int si = allElements.size();
//        System.out.println(si);
//        for(int i=0;i<allElements.size(); i++){
//            driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
//        }

//        System.out.println(driver.findElement(By.xpath("hm" +"//*[@id=\"content\"]/div/div[1]/ul[1]/li")).getSize());


        driver.findElement(By.className("mfp-close")).click();

        //     - Click on 'Write a review' , fill information and submit

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"input-review\"]")).sendKeys("It's amazing!!!There are " +
                "many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in " +
                "some form, by injected humour, or randomised words which don't look even slightly");
        driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();


        // click add to card

        driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();

        WebElement spa = driver.findElement(By.xpath("//*[@id=\"cart-total\"]"));
        System.out.println(spa.getText());
        if (spa.getText().equals("1 item(s) - $122.00")) {
            System.out.println("Done");
        } else {
            System.out.println("False");
        }

        //    - Click on Pic2 element and click on 'Checkout'

        driver.findElement(By.className("btn-inverse")).click();
        driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]")).click();

        //Fill Billing Details, choose Georgia and Tbilisi
        driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
        WebElement Dr1 = driver.findElement(By.cssSelector("select#input-country"));

//        WebElement Dr1 = driver.findElement(By.xpath("//*[@id=\"input-country\"]"));
        Select chooseDr1 = new Select(Dr1);
        chooseDr1.selectByVisibleText("Georgia");
        Thread.sleep(1000);
//        WebDriverWait wait= new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-zone\"]")));
        WebElement Dr2 = driver.findElement(By.xpath("//*[@id=\"input-zone\"]"));
        Select chooseDr2 = new Select(Dr2);
        chooseDr2.selectByVisibleText("Tbilisi");

        driver.findElement(By.xpath("//*[@id=\"input-postcode\"]")).sendKeys("0102");
        //selectByVisibleText(String)-
        driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();





    }
}

