package TestNG_demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by qiuwei on 2016/11/13.
 */

public class TestNG_Demo_Groups {
    String str ;
    //@Test(groups = {"functest", "checkintest"})
    //public void testMethod1() {
    //    System.out.println("This is functest and checkintest");
    //}
    @Parameters({"str"})
    @Test(groups = "checkintest")
    public void testMethod2( @Optional("qiuqiu1") String str) {
        System.out.println(str);
        System.out.println("This is checkintest");
    }

    @Test(groups = {"functest"})
    public void testMethod3() {
        System.out.println("This is functest");
    }
}

