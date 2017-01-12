package Demo;

import org.testng.annotations.Test;

/**
 * Created by qiuwei on 2016/11/12.
 */
public class TestNG_Demo_TestValue {
    private String str = "";

    @Test(groups = "testDepends")
    public void test(){
        System.out.println("I'm 1");
        str="I'm 谢昭富";
    }

    @Test(dependsOnGroups = "testDepends")
    public void test3(){
        System.out.println("I'm 3");
    }

    @Test(dependsOnMethods = "test4" )
    public void test2(){
        System.out.println("I'm 2");
    }

    @Test
    public void test4(){
        System.out.println("I'm 4");
    }
}
