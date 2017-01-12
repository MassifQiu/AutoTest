package UIFramework;

/**
 * Created by qiuwei on 2016/12/22.
 */
public class Page extends WebElementUtils {

    public Page(int driverType) {
        super(driverType);
    }

    public static void main(String[] args) {
        Page page = new Page(1);
        page.findElementBy_xpath("//");
    }
}
