import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by qiuwei on 2016/11/5.
 */
public class LoginPage {

    public void login(WebElementUtils elementUtils,String yamlFile,
                      String userKey,String passwordKey,String user,String password,String button){
        elementUtils.getKeyMap(yamlFile);
        elementUtils.findElement(userKey).sendKeys(user);
        elementUtils.findElement(passwordKey).sendKeys(password);
        elementUtils.findElement(button).click();

        Map<String , String[]> map = new HashMap<String, String[]>();
    }

    //public static void main(String[] args) {
    //    //final String URL = "http://192.168.1.252:81/zentao/user-login-L3plbnRhby8=.html";
    //    final String URL = "http://192.168.1.108:81/zentao/user-login.html";
    //    WebElementUtils test = new WebElementUtils(1);
    //    //启动全新浏览器
    //    //System.setProperty("webdriver.chrome.driver","webdriver//chromedriver 2");
    //    //test.driver = new ChromeDriver();
    //
    //    //打开网页
    //    //第一种方法：driver.get("url")
    //    test.openWeb(URL);
    //    //第二种方法：driver.navigate().to("url")
    //    //driver.navigate().to(URL);
    //
    //    //浏览器最大化
    //    //test.driver.manage().window().maximize();
    //
    //    //页面刷新
    //    //test.driver.navigate().refresh();
    //
    //    //定位用户名输入框
    //    //第一种方法：通过元素id定位元素
    //    //test.getYamlFile("login");
    //    //test.getElement("login_user").sendKeys("xiezhaofu");
    //    //test.getElement("login_password").sendKeys("123456");
    //
    //    test.findElement("login_user").sendKeys("xiezhaofu");
    //    test.findElement("login_password").sendKeys("123456");
    //    //WebElement element = test.driver.findElement(By.id("account"));
    //
    //    //driver.findElement(By.name("account"));
    //
    //    //driver.findElement(By.className("form-control"));
    //
    //    //driver.findElement(By.xpath("//*[@id='account']"));
    //
    //    //在用户名输入框中输入数据
    //    //element.sendKeys("xiezhaofu");
    //
    //    //Actions actions = new Actions(driver);
    //    //actions.sendKeys("");
    //
    //    //test.driver.findElement(By.name("password")).sendKeys("123456");
    //
    //    test.findElementBy_id("submit").click();
    //
    //    String abc = test.findElementBy_id("searchQuery").getAttribute("placeholder");
    //
    //    System.out.println(abc);
    //}
}
