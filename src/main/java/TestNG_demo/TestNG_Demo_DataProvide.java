package TestNG_demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiuwei on 2016/11/15.
 */
public class TestNG_Demo_DataProvide {

    public static String fileName = "testcase";
    public static String sheetName = "login";

    //数据提供商放在具体的page类
    @DataProvider(name = "dp_qiuqiu")
    //数据的提供商
    public Object[][] getData() throws IOException {
        //System.out.println("This is BeforeTest");
        ReadExcel excel = new ReadExcel(fileName, sheetName);
        return excel.getExcelData();
    }

    //数据的使用者放在page类的测试类中
    @Test(dataProvider = "dp_qiuqiu")
    public void test(HashMap<String, String> data) {
        //System.out.println(data.toString());
        Iterator iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            String val = entry.getValue().toString();
        }
        //System.out.println(data.get("login_user"));
        System.out.println(data.get("login_password").replace(".0",""));
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", new Integer(36)},
                {"Anne", new Integer(37)},
        };
    }

    //This test method declares that its data should be supplied by the Data Provider  
    //named "test1"  
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

}

