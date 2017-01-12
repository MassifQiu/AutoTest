package UIFramework;

import Utils.MyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

/**
 * Created by qiuwei on 2016/11/7.
 */
public class BrowserUtils extends Browser {

    public BrowserUtils(int driverType) {
        super(driverType);
    }


    //获取Driver
    /*
    */
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

    /**
     * TODO:暂停
     * @param milliseconds
     */
    public void pause(long milliseconds) {
        if (milliseconds <= 0) {
            System.out.println("时间异常");
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

    /**
     *
     * @Title: screenShot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 作者：邱卫武
     * @date 创建时间：2015年8月11日下午5:08:49
     * @param @param picName     参数
     * @return void    返回类型
     * @throws
     */
    public void screenShot(String picName) {
        pause(500);
        String strPicPath = MyUtils.stringLastedCharIs(SeleniumConfig.SCREENSHOT_PATH, "/");
        strPicPath = strPicPath + MyUtils.getNowTime("yyyy") + "/";
        strPicPath = strPicPath + MyUtils.getNowTime("MM") + "/";
        strPicPath = strPicPath + MyUtils.getUniNum() + "_";
        this.sshot(strPicPath, picName);// 截图
    }

    /**
     *
     * @Title: screenShot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 作者：邱卫武
     * @date 创建时间：2015年8月11日下午5:08:56
     * @param @param path
     * @param @param picName     参数
     * @return void    返回类型
     * @throws
     */
    public void screenShot(String path, String picName) {
        pause( 500);
        this.sshot(path, picName);// 截图
    }

    /**
     *
     * @Title: sshot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 作者：邱卫武
     * @date 创建时间：2015年8月11日下午5:09:02
     * @param @param strPicPath
     * @param @param picName     参数
     * @return void    返回类型
     * @throws
     */
    private void sshot(String strPicPath, String picName) {
        picName = picName.replace("/", "_").replace("\\", "_");
        File picFile = new File(strPicPath + picName + ".png");

        // 截图支持滚屏
        File source_file = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        // 将图另存为
        try {
            FileUtils.copyFile(source_file, picFile);
        } catch (IOException e) {
            report.error("截图失败！！！ " + picFile.toString());
            e.printStackTrace();
        }
        // report.log("截图：" + picFile.toString());
        report.screenShotLog("截图：" + picName, picFile);
    }
}
