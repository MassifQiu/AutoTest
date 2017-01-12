package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by qiuwei on 2016/12/27.
 */
public class Baidu {
    public static void main(String[] args) throws InterruptedException {
        //127.0.0.1 问题，这个是selenium版本跟你目前的Firefox/chrome的版本不兼容
        //第一个参数，driver类型，第二个参数，driver位置
        System.setProperty("webdriver.gecko.driver", "webdriver//geckodriver");
        WebDriver driver = new FirefoxDriver();

        //浏览器最大化
        driver.manage().window().maximize();

        Thread.sleep(500);
        //打开百度页面
        driver.get("http://www.baidu.com");
        //获取当前URL
        System.out.println("当前URL为：" + driver.getCurrentUrl());

        //输入webdriver搜索
        //driver.findElement(By.id("kw")).sendKeys("webdriver");
        //driver.findElement(By.id("su")).click();

        //driver.findElement(By.name("wd")).sendKeys("webdriver");
        driver.findElement(By.className("s_ipt")).sendKeys("webdriver");

        WebElement element = driver.findElement(By.xpath("//span[@class='bg s_btn_wr']"));

        //List<WebElement> elementList = driver.findElements(By.xpath(""));

        Thread.sleep(200);
        element.findElement(By.tagName("input")).click();

        driver.findElement(By.id("id")).findElement(By.xpath(""));
        Actions actions = new Actions(driver);
        actions.clickAndHold();
        actions.sendKeys("a");
        driver.switchTo().defaultContent();
        driver.switchTo().window("");
        //Thread.sleep(2000);
        //
        ////后退
        //driver.navigate().back();
        //
        //Thread.sleep(2000);
        ////前进
        //driver.navigate().forward();
        //
        //Thread.sleep(2000);
        ////刷新
        //driver.navigate().refresh();
        //
        ////获取title
        //System.out.println(driver.getTitle());
        //
        ////关闭标签页
        //driver.close();
        //
        ////退出浏览器
        //driver.quit();
    }

}
