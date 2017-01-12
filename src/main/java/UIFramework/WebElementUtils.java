package UIFramework;

import Utils.YamlUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

/**
 * Created by qiuwei on 2016/11/8.
 */

public class WebElementUtils extends BrowserUtils {

    public YamlUtils yaml = new YamlUtils(dr);
    private HashMap<String, HashMap<String, String>> keyMap;

    //构造方法
    public WebElementUtils(int driverType) {
        super(driverType);
    }

    //获取yaml文件中的值
    public void getKeyMap(String yamlFile) {
        keyMap = yaml.getYamlData(yamlFile);
    }

    //根据yaml文件中的key值，等待10秒再定位元素
    public WebElement findElement(String key) {
        //keyMap = {login_user:{type : id,value : kw},login_password:}
        report.log("开始定位元素:" + key);
        String type = keyMap.get(key).get("type");
        String value = keyMap.get(key).get("value");
        WebElement element = yaml.waitForElement(yaml.getBy(type, value));
        report.greenLight("定位到元素:" + key);
        //判断元素是否显示
        if (!yaml.waitElementToBeDisplayed(element)) {
            element = null;
            System.out.println("元素被隐藏");
        }
        return element;
    }

    //根据yaml文件key值，不等待直接定位元素
    public WebElement findElementNoWait(String key) {
        WebElement element = null;
        String type = keyMap.get(key).get("type");
        String value = keyMap.get(key).get("value");
        try {
            element = dr.findElement(yaml.getBy(type, value));
        } catch (Exception e) {
            element = null;
        }
        return element;
    }

    /**
     * TODO 通过id定位元素
     *
     * @param id String
     * @return WebElement
     * @author qiuwei
     * @dateTime 2016/11/8 14:58
     */
    public WebElement findElementBy_id(String id) {
        pause(10);
        WebElement element = null;
        try {
            element = dr.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("定位元素出错了");
        }
        System.out.println("定位到元素" + id);
        return element;
    }

    /**
     * TODO 通过name定位元素
     *
     * @param name String
     * @return WebElement
     * @author qiuwei
     * @dateTime 2016/11/8 14:55
     */
    public WebElement findElementBy_name(String name) {
        pause(100);
        WebElement element = null;
        try {
            element = dr.findElement(By.name(name));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("定位元素出错了");
        }
        System.out.println("定位到元素" + name);
        return element;
    }

    /**
     * TODO 通过classname定位元素
     *
     * @param classname String
     * @return WebElement
     * @author qiuwei
     * @dateTime 2016/11/8 16:17
     */
    public WebElement findElementBy_classname(String classname) {
        pause(100);
        WebElement element = null;
        try {
            element = dr.findElement(By.className(classname));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("定位元素出错了");
        }
        System.out.println("定位到元素" + classname);
        return element;
    }

    /**
     * TODO 通过xpath定位元素
     *
     * @param xpath String
     * @return WebElement
     * @author qiuwei
     * @dateTime 2016/11/8 16:18
     */
    public WebElement findElementBy_xpath(String xpath) {
        pause(100);
        WebElement element = null;
        try {
            element = dr.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            System.out.println("定位元素失败");
        }
        System.out.println("定位到元素" + xpath);
        return element;
    }


    /**
     * TODO 通过By定位元素组
     *
     * @param by By
     * @return List<WebElement>
     * @author qiuwei
     * @dateTime 2016/11/8 16:19
     */
    public List<WebElement> findElements_By(By by) {
        pause(100);
        List<WebElement> elements = null;
        try {
            elements = dr.findElements(by);
        } catch (NoSuchElementException e) {
            System.out.println("定位元素组合失败");
        }
        return elements;
    }

    /**
     * TODO 定位元素组 -- xpath
     *
     * @param xpath String
     * @return List
     * @author qiuwei
     * @dateTime 2016/11/8 17:13
     */
    public List<WebElement> findElements_xpath(String xpath) {
        pause(100);
        List<WebElement> elements = null;
        try {
            elements = dr.findElements(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            System.out.println("定位元素组合失败");
        }
        return elements;
    }

    /**
     * TODO 清空元素 -- xpath
     *
     * @param xpath String
     * @return void
     * @author qiuwei
     * @dateTime 2016/11/8 16:20
     */
    public void clear(String xpath) {
        pause(100);
        WebElement element = findElementBy_xpath(xpath);
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("清空【" + xpath + "】元素失败");
        }
        System.out.println("清空【" + xpath + "】元素");
    }

    /**
     * TODO 清空元素 -- element
     *
     * @param element WebElement
     * @return void
     * @author qiuwei
     * @dateTime 2016/11/8 16:21
     */
    public void clear(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.println("清空" + element + "元素失败");
        }
        System.out.println("清空" + element + "元素");
    }

    /**
     * TODO 点击元素 -- xpath
     *
     * @param xpath String
     * @return void
     * @author qiuwei
     * @dateTime 2016/11/8 16:22
     */
    public void click(String xpath) {
        pause(100);
        WebElement element = findElementBy_xpath(xpath);
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("点击" + xpath + "元素失败");
        }
        System.out.println("点击" + xpath + "元素");
    }

    /**
     * TODO
     *
     * @param element WebElement
     * @return void
     * @author qiuwei
     * @dateTime 2016/11/8 16:23
     */
    public void click(WebElement element) {
        pause(100);
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("点击" + element + "元素失败");
        }
        System.out.println("点击" + element + "元素");
    }

    /**
     * TODO 点击Alert确定
     *
     * @author qiuwei
     * @dateTime 2016/11/8 16:24
     */
    public void click_Alert_Accept() {
        pause(100);
        try {
            dr.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("点击确定失败");
        }
        System.out.println("点击Alert确定");
    }

    /**
     * TODO 点击Alert取消
     *
     * @author qiuwei
     * @dateTime 2016/11/8 16:25
     */
    public void click_Alert_Dismiss() {
        pause(100);
        try {
            dr.switchTo().alert().dismiss();
        } catch (Exception e) {
            System.out.println("点击取消失败");
        }
        System.out.println("点击Alert取消");
    }

    /**
     * TODO 获取Alert信息
     *
     * @return String
     * @author qiuwei
     * @dateTime 2016/11/8 16:25
     */
    public String get_Alert_Text() {
        pause(100);
        String text = null;
        try {
            text = dr.switchTo().alert().getText();
        } catch (Exception e) {
            System.out.println("获取Alert信息失败");
        }
        System.out.println("获取Alert的信息为：" + text);
        return text;
    }

    /**
     * TODO 输入动作 -- xpath
     *
     * @param xpath String
     * @param text  Object
     * @author qiuwei
     * @dateTime 2016/11/8 16:26
     */
    public void input(String xpath, Object text) {
        pause(100);
        WebElement element = findElementBy_xpath(xpath);
        inputAction(element, text);
    }

    /**
     * TODO 输入动作 -- element
     *
     * @param element WebElement
     * @param text    Object
     * @author qiuwei
     * @dateTime 2016/11/8 16:27
     */
    public void input(WebElement element, Object text) {
        pause(100);
        inputAction(element, text);
    }

    /**
     * TODO 输入动作
     *
     * @param element WebElement
     * @param text    Object
     * @author qiuwei
     * @dateTime 2016/11/8 16:28
     */
    private void inputAction(WebElement element, Object text) {
        clear(element);
        if (text == null || text.equals("")) {
            System.out.println("不做输入操作");
            return;
        }
        try {
            element.sendKeys(text.toString());
            System.out.println("输入 [" + text.toString() + "]");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("输入 [" + text.toString() + "] 失败");
        }
    }

    public String get_Text(WebElement element) {
        return element.getText();
    }

    public String get_Text(String xpath) {
        return findElementBy_xpath(xpath).getText();
    }

    public String get_InputText(String xpath) {
        return findElementBy_xpath(xpath).getAttribute("value");
    }

    public void select_ByIndex(String xpath, int index) {
        pause(100);
        Select select = new Select(findElementBy_xpath(xpath));
        try {
            select.selectByIndex(index);
        } catch (Exception e) {
            System.out.println("下拉选择框选择第" + index + "个选项操作失败");
        }
    }

    public void select_ByValue(String xpath, Object value) {
        select_ByValue(findElementBy_xpath(xpath), value);
    }

    public void select_ByValue(WebElement element, Object value) {
        pause(100);
        if (value == null || value.equals("")) {
            System.out.println("参数value为空，不做选择操作");
            return;
        }
        String val = value.toString();
        try {
            Select select = new Select(element);
            select.selectByVisibleText(val);
        } catch (NoSuchElementException e) {
            System.out.println("找不到元素" + element);
        } catch (Exception e) {
            System.out.println("下拉菜单中，[" + val + "]选项不存在");
        }
    }

    public void waitElement(final String xpath, long timeoutsecond) {
        WebDriverWait wait = new WebDriverWait(dr, timeoutsecond);
        wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    public void waitElement(final WebElement element, long timeoutsecond) {
        WebDriverWait wait = new WebDriverWait(dr, timeoutsecond);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });
    }
}
