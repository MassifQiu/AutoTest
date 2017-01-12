import Utils.ReportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


/**
 * Created by qiuwei on 2017/1/7.
 */
public class BaiduTest {
    WebDriver driver;
    ReportUtils report = new ReportUtils();

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        //浏览器的配置项
        System.setProperty("webdriver.gecko.driver", "webdriver//geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        report.log("启动Firefox浏览器");
        //打开禅道
        driver.get("http://www.baidu.com");

        Thread.sleep(200);
    }

    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        WebElement input = driver.findElement(By.id("kw1"));
        Thread.sleep(500);
        input.sendKeys("WebDriver");
        report.log("输入Webdriver");
        WebElement submit = driver.findElement(By.id("su1"));
        Thread.sleep(200);
        report.log("点击百度一下");
        submit.click();
    }

    @AfterTest
    public void afterTest(){
        report.log("测试结束");
    }
}
