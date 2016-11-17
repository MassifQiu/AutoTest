import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by qiuwei on 2016/11/7.
 */
public class BrowserUtils extends Browser {

    public BrowserUtils(int driverType) {
        super(driverType);
    }

    //获取Driver
    public WebDriver getDriver() {
        return dr;
    }

    //打开页面
    public void openWeb(String url) {
        dr.get(url);
        System.out.println("打开【"+url+"】页面");
    }

    //关闭页面
    public void closeWeb() {
        dr.close();
    }

    //暂停操作
    public void pause(long milliseconds) {
        if (milliseconds <= 0) {
            return;
        }
        try {
            Thread.sleep(milliseconds);
            System.out.println("暂停：" + milliseconds + "秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("异常：" + e.toString());
        }
    }

    //退出浏览器
    public void quit() {
        dr.quit();
        System.out.println("关闭浏览器");
    }

    //获取当前页面URL

    public String getCurrentUrl() {
        String CurrentUrl = dr.getCurrentUrl();
        System.out.println("当前页面为：" + CurrentUrl);
        return CurrentUrl;
    }

    //刷新页面
    public void refresh() {
        dr.navigate().refresh();
        System.out.println("刷新页面");
    }

    //切换窗口
    public WebDriver switchTo_window(String windowHaddle) {
        WebDriver driver = dr.switchTo().window(windowHaddle);
        return driver;
    }

    //根据页面名称orID切换页面
    public WebDriver switch_Frame(String frame) {
        WebDriver driver = dr.switchTo().frame(frame);
        System.out.println("切换到" + frame + "页面");
        return driver;
    }


    //根据页面索引位置切换页面
    public WebDriver switch_Frame(int index) {
        WebDriver driver = dr.switchTo().frame(index);
        System.out.println("切换到第" + index + "个页面");
        return driver;
    }

    //根据页面元素切换页面
    public WebDriver switch_Frame(WebElement element) {
        WebDriver driver = dr.switchTo().frame(element);
        System.out.println("切换到" + element.getText() + "元素");
        return driver;
    }

    //前进
    public void forword() {
        dr.navigate().forward();
        System.out.println("执行浏览器前进操作");
    }

    //后退

    public void back() {
        dr.navigate().back();
        System.out.println("执行浏览器后退操作");
    }
}
