package Demo;

import Utils.UtilsIterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiuwei on 2017/1/4.
 */
public class DataTest {
    @DataProvider(name = "dp")
    public Iterator<Object []> beforeTest() throws IOException {
        return new UtilsIterator("testcase.xls","login");
    }

    @Test(dataProvider = "dp")
    public void test(Map<String,String> map){
        //System.out.println(map);
        System.out.println(map.get("login_user"));
    }

    @DataProvider(name = "123")
    public Object[][] beforeTest1() throws IOException {
        return new UtilsIterator("","").readExcel03("","");
    }

    //数据提供商,创建数据
    //注解名称DataProvider
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {{ "qiuqiu", 17}, { "shenjie", 250},};
    }

    //接受数据提供商的数据，使用数据
    //@Test注解中的属性dataProvider
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }
}
