import java.util.ResourceBundle;

/**
 * Created by qiuwei on 2016/11/18.
 */
public class SeleniumConfig {
    private final static ResourceBundle rb = ResourceBundle.getBundle("selenium");

    public final static String ZENDAO_URL = rb.getString("zendao.url");
    public final static String SCREENSHOT_PATH = rb.getString("screenShot.path");
    public final static String DRIVER_TYPE =  rb.getString("driverType");
    public final static String REPORT_PATH = rb.getString("reportPath");
    public final static String SRC_REPORT = rb.getString("sourceReport");
}
