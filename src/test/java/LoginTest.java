import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by qiuwei on 2016/11/11.
 */
public class LoginTest {

    @Test
    public void test() {
        String URL = "http://192.168.1.108:81/zentao/user-login.html";
        String URL1 = "http://192.168.1.252:81/zentao/user-login-L3plbnRhby8=.html";
        LoginPage page = new LoginPage();
        WebElementUtils driver = new WebElementUtils(1);
        driver.openWeb(URL1);
        page.login(driver, "login", "login_user", "login_password", "xiezhaofu", "123456", "login_button");
    }
}

