import Utils.CheckPoint;
import Utils.ReportUtils;
import Utils.UtilsIterator;
import Utils.YamlUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiuwei on 2017/1/5.
 */
public class DemoTest {
    private WebDriver driver;
    private YamlUtils yamlUtils = new YamlUtils(driver);
    private HashMap<String, HashMap<String, String>> keyMap;
    private static Logger logger = Logger.getLogger(DemoTest.class);
    ReportUtils report = new ReportUtils();
    CheckPoint check = new CheckPoint();

    private void setKeyMap(String fileName) {
        this.keyMap = yamlUtils.getYamlData(fileName);
    }

    /*
    1、从线性脚本开始
    2、WebDriver 二次封装
        (1)、浏览器启动
        (2)、浏览器操作
        (3)、页面元素定位与操作
        (4)、小工具
    3、TestNG 测试驱动
        (1)、通过注解来驱动测试
        (2)、通过xml来驱动测试
        (3)、通过TestNG建立测试依赖
        (4)、TestNG参数化
                1）、Parameters
                2)、Dataprovider
     4、Yaml 元素分离
        (1)、创建一个Yaml文件
        (2)、解析Yaml文件数据
        (3)、构建By对象
        (4)、根据Yaml中的数据定位元素
     5、断言 TestNG
        TestNG  Assert
     6、日志，报告
        Log4j
            (1) 日志级别以及目的地
            (2) 目的地赋值
            (3) 输出的样式
        ReportNG
            (1) Utils.ReportUtils   log,info,debug....
            (2) 在xml中，监听TestNG报告
     7、配置项
         (1) 创建一个配置文件
         (2) 创建一个类，将配置项声明为常量，静态
         (3) 在代码中使用 类名.属性名 的方式进行调用
     8、整理项目

     9、Git
     */
    //@Parameters({"url","fileName"})
    //@BeforeMethod
    //public void beforeTest(String url,String fileName) throws InterruptedException {
    //    setKeyMap(fileName);
    //    //浏览器的配置项
    //    System.setProperty("webdriver.gecko.driver", "webdriver//geckodriver");
    //    driver = new FirefoxDriver();
    //    driver.manage().window().maximize();
    //    report.log("启动Firefox浏览器");
    //    //打开禅道
    //    driver.get(url);
    //    Thread.sleep(200);
    //}
    //
    //@DataProvider(name = "dp")
    ////Object[][]
    //// Iterator<Object[]>
    //public Iterator<Object []> beforeTest() throws IOException {
    //    return new UtilsIterator("testcase.xls","login");
    //}
    //dataProvider : 数据提供商（Dataprovider所注解的方法），数据使用商(Test所注解的方法，Test的一个属性)
    //
    //@Parameters({"userName", "passWord"})
    //@Test(dataProvider = "dp")
    //public void test(Map<String,String> map) throws InterruptedException {
    //    //执行登录操作
    //    WebElement login_user = findElement("login_user");
    //    login_user.clear();
    //    login_user.sendKeys(map.get("login_user"));
    //    WebElement password = findElement("login_password");
    //    password.clear();
    //    password.sendKeys(map.get("login_password"));
    //    Thread.sleep(5000);
    //    findElement("login_button").click();
    //    //处理密码错误弹框
    //    //Thread.sleep(500);
    //    //Alert alert = driver.switchTo().alert();
    //    //String alertText = alert.getText();
    //    //report.log(alertText);
    //    //String expected = "登录失败，请检查您的用户名或密码是否填写正确。";
    //    //check.checkString(alertText,expected);
    //    //Thread.sleep(200);
    //    //alert.accept();
    //
    //    //password.clear();
    //    //password.sendKeys(map.get("login_password"));
    //    //findElement("login_button").click();
    //    Thread.sleep(5000);
    //    driver.quit();
    //}


    //public WebElement findElement(String elementName) {
    //    String type = keyMap.get(elementName).get("type");
    //    String value = keyMap.get(elementName).get("value");
    //    return driver.findElement(yamlUtils.getBy(type, value));
    //}

    @DataProvider(name = "dp1")
    public Iterator<Object[]> beforeTest1() throws IOException {
        return new UtilsIterator("testcase.xls", "login");
    }

    @Test(dataProvider = "dp1", dependsOnMethods = ""  )
    public void test1(Map<String, String> map) {
        System.out.println("UserName =" + map.get("login_user"));
        System.out.println("Password =" + map.get("login_password"));
    }
    /*
    public static void main(String[] args) throws InterruptedException {

        //浏览器的配置项
        System.setProperty("webdriver.gecko.driver", "webdriver//geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("启动Firefox浏览器");
        //打开禅道
        driver.get("http://192.168.0.104:81/zentao/user-login-L3plbnRhby8=.html");
        Thread.sleep(200);

        //执行登录操作
        WebElement login_user = driver.findElement(By.id("account"));
        login_user.clear();
        login_user.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("12345");
        driver.findElement(By.id("submit")).click();
        //处理密码错误弹框
        Thread.sleep(200);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        if (alertText.equals("登录失败，请检查您的用户名或密码是否填写正确。")) {
            System.out.println("弹框测试通过");
        } else {
            System.out.println("提示信息错误");
        }
        Thread.sleep(200);
        alert.accept();

        password.clear();
        password.sendKeys("123456");
        driver.findElement(By.id("submit")).click();

        driver.close();
    }
    */
}
