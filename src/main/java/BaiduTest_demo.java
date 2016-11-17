import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by qiuwei on 16/10/31.
 */
public class BaiduTest_demo {

    public static void main(String[] args) throws InterruptedException {
        //定义地址常量URL
        final String URL = "http://192.168.1.252:81/zentao/user-login-L3plbnRhby8=.html";
        final String baiduUrl = "http://www.baidu.com";

        //启动浏览器
        System.setProperty("webdriver.gecko.driver", "webDriver//geckodriver");
        WebDriver driver = new FirefoxDriver();
//      System.setProperty("webdriver.chrome.driver", "webDriver//chromedriver 2");
//      WebDriver driver1 = new ChromeDriver();

        //打开网页
        driver.get(URL);
        //driver.navigate().to("");

        //获取窗口的句炳
        System.out.println(driver.getWindowHandle());
        driver.switchTo().window(driver.getWindowHandle());

        //获取窗口的当前页面的URL
        System.out.println(driver.getCurrentUrl());

        //获取当前页面的Title
        System.out.println(driver.getTitle());

        //隐性等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //登陆操作

        //通过xpath定位元素
        //driver.findElement(By.xpath("//input[@id='account']")).sendKeys("admin");

        //通过className定位元素
        //WebElement userName = driver.findElement(By.className("form-control"));
        //userName.sendKeys("admin");

        //通过id定位元素
        //WebElement userName = driver.findElement(By.id("account"));
        //userName.sendKeys("admin");

        //通过name定位元素
        //WebElement userName = driver.findElement(By.name("account"));
        //userName.sendKeys("admin");



        //通过xpath定位元素
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("admin");

        //driver.findElements(By.)

        //通过name属性定位元素
        driver.findElement(By.name("password")).sendKeys("123456");
        //通过ID定位元素
        driver.findElement(By.id("submit")).click();
        //硬性等待500ms
        Thread.sleep(500);
        //点击测试按钮
        //driver.findElement(By.xpath("//a[@href = '/zentao/qa/']")).click();

        //多个元素定位
        List<WebElement> testButton = driver.findElements(By.linkText("测试"));
        testButton.get(0).click();
        Thread.sleep(500);

        //点击测试按钮
        //WebElement element = driver.findElement(By.xpath("//a[@href='/zentao/qa/']"));
        //element.click();

        Thread.sleep(500);
        //浏览器后退操作
        driver.navigate().back();
        Thread.sleep(500);
        //浏览器前进操作
        driver.navigate().forward();
        //浏览器页面刷新操作
        driver.navigate().refresh();
        //退出浏览器
        //driver.quit();

        //层级定位元素:先定位父元素
        //通过id定位元素
        WebElement userMenu = driver.findElement(By.id("userMenu"));
        Thread.sleep(500);
        userMenu.click();
        //通过父元素定位子元素
        //通过LinkText定位元素
        userMenu.findElement(By.linkText("个人档案")).click();

        //通过classname定位元素
        driver.switchTo().frame("modalIframe");

//        WebElement div = driver.findElement(By.className("container mw-600px"));

        WebElement table = driver.findElement(By.xpath("//table[@class='table table-borderless table-data']"));
        System.out.println(table.findElement(By.xpath("//th[contains(text(),'用户名')]")).getText());
        System.out.println(driver.findElement(By.xpath("//th[contains(text(),'真实姓名')]")).getText());
        System.out.println(driver.findElement(By.xpath("//th[contains(text(),'真实姓名')]")).toString());

//        System.out.println(driver.findElement(By.className("icon-user")));



//
    }
}
