package Demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiuwei on 2016/11/15.
 */
public class Test_DataProvider {

    @Test(dataProvider = "dp")
    public void test(Map<String, Object> data) {
        Object key = null;
        Object val = null;
        Iterator iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
             key = entry.getKey();
            val = entry.getValue();
        }
        System.out.println(val.toString());
    }
}
