import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by qiuwei on 2016/12/19.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        String URL ="http://192.168.1.154:81/zentao/user-login-L3plbnRhby8=.html";


        //加载浏览器驱动，参数1驱动类型，参数2驱动地址
        System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver");
        //System.setProperty("webdriver.chrome.driver","webDriver//chromedriver 2");
        WebDriver driver = new FirefoxDriver();

        Actions actions = new Actions(driver);
        //打开页面
        driver.get(URL);

        Thread.sleep(500);
        //定位系统名称
        WebElement text = driver.findElement(By.className("panel-head")).findElement(By.tagName("h4"));
        System.out.println(text.getText());

        //语言切换按钮
        WebElement languageButton = driver.findElement(By.id("langs")).findElement(By.className("btn"));
        languageButton.click();
        Thread.sleep(500);
        //语言切换选项
        WebElement chinese = driver.findElement(By.xpath("//a[contains(text(),'简体')]"));
        System.out.println(chinese.getText());

        WebElement english = driver.findElement(By.xpath("//a[contains(text(),'English')]"));
        System.out.println(english.getText());
        System.out.println(english.getText().compareTo("English"));

        WebElement fanti = driver.findElement(By.xpath("//a[contains(text(),'繁體')]"));
        System.out.println(fanti.getText());

        //手机按钮
        WebElement mobile = driver.findElement(By.id("mobile"));
        mobile.click();

        //用户名输入框
        WebElement userName = driver.findElement(By.className("form-control"));
        userName.sendKeys("admin");

        int height = userName.getSize().height;
        int width = userName.getSize().width;
        System.out.println(height);
        System.out.println(width);

        int x = userName.getLocation().getX();
        System.out.println(x);

        //获取id的值
        System.out.println(userName.getAttribute("id"));
        //密码输入框
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("123456");
        passWord.sendKeys();
        //保持登录按钮
        WebElement keepLogining = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if(keepLogining.isSelected() == false){
                keepLogining.click();
        }
        //keepLogining.click();
        //登录按钮
        WebElement login = driver.findElement(By.xpath("//button[starts-with(@id,'submit')]"));
        System.out.println(login.getText());
        actions.doubleClick(login).release();
        actions.sendKeys(Keys.TAB);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.switchTo().window(driver.getWindowHandle());




    }

}
