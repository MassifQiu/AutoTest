package UIFramework;

import Utils.ReportUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiuwei on 2016/11/4.
 */

public class Browser {

    WebDriver dr;
    protected static Logger logger = Logger.getLogger(Browser.class.getName());
    ReportUtils report = new ReportUtils();

    public Browser(int driverType){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("pkill Google Chrome");
            runtime.exec("pkill Firefox");
        }catch (IOException e){
            System.out.println("关闭程序异常");
            report.error("关闭程序异常");
        }
        setUpDriver(Integer.getInteger(SeleniumConfig.DRIVER_TYPE));
        Timeouts timeouts = dr.manage().timeouts();
        TimeUnit se =TimeUnit.SECONDS;
        // 页面跳转或刷新的超时时间设置(页面加载时间设置)
        timeouts.pageLoadTimeout(10,se);
    }

    //根据浏览器类型选择启动的浏览器
    private void setUpDriver(int driverType) {
        switch (driverType){
            case 1:
                setUpChrome();
                break;
            case 2:
                setUpFirefox();
                break;
            case 3:
                setUpFirefox_Profile();
                break;
            default:
                setUpChrome();
        }
    }

    //启动全新配置的Firefox浏览器
    private void setUpFirefox() {
        //浏览器的配置项
        System.setProperty("webdriver.gecko.driver", "webdriver//geckodriver");
        dr = new FirefoxDriver();
        maximizeDriver();
        System.out.println("启动Firefox浏览器");
        report.log("启动Firefox浏览器");
    }

    //启动Chrome浏览器
    public void setUpChrome() {
        System.setProperty("webdriver.chrome.driver", "webdriver//chromedriver 2");
        dr = new ChromeDriver();
        maximizeDriver();
        report.log("启动Chrome浏览器");
    }

    //启动用户默认配置Firefox浏览器
    public void setUpFirefox_Profile(){
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile profile = allProfiles.getProfile("default");
        System.setProperty("webdriver.gecko.driver", "webdriver//geckodriver");
         dr = new FirefoxDriver(profile);
        maximizeDriver();
        System.out.println("启动默认配置Firefox浏览器");
    }

    //浏览器最大化
    public void maximizeDriver(){
        dr.manage().window().maximize();
    }

    public static void main(String[] args) {
        Browser browser = new Browser(1);
        browser.setUpChrome();
    }

}
