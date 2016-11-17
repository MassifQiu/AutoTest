import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by qiuwei on 2016/11/11.
 */
public class YamlUtils {
    WebDriver driver;

    public YamlUtils(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,HashMap<String,String>> getYamlData(String yamlFile){
        HashMap<String,HashMap<String,String>> keyMap =null;
        File file = new File("elements/" + yamlFile + ".yaml");
        try {
            //将yaml文件中的数据存入到keyMap中
            keyMap = Yaml.loadType(new FileInputStream(file.getAbsolutePath())
                    , HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return keyMap;
    }

    public By getBy(String type ,String value){
        By by = null;
        if (type.equals("id")){
            by = By.id(value);
        }
        if (type.equals("xpath")){
            by = By.xpath(value);
        }
        if (type.equals("name")){
            by = By.name(value);
        }
        return by;
    }


    public WebElement waitForElement(final By by) {
        WebElement element = null;
        //int waitTime = Integer.parseInt(Config.getConfig("waitTime"));

        try {
            element = new WebDriverWait(driver, 10)
                    .until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver driver) {
                            return driver.findElement(by);
                        }
                    });
        } catch (Exception e) {
            System.out.println(by.toString() + " is not exist until " + 10);
        }
        return element;
    }

    public boolean waitElementToBeDisplayed(final WebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {
            wait = new WebDriverWait(driver, 10)
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            return element.isDisplayed();
                        }
                    });
        } catch (Exception e) {
            System.out.println(element.toString() + " is not displayed");
        }
        return wait;
    }
}
