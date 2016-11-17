package TestNG_demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by qiuwei on 2016/11/13.
 */
public class TestNG_Demo_Param {

    @Parameters({"name", "age"})
    @Test
    public void setName(@Optional("xiezhaofu") String name, @Optional("18") int age) {
        System.out.println("name =" + name);
        System.out.println("age = " + age);
    }

    @Parameters({"name"})
    @Test
    public void setName2(String name){
        System.out.println(name);
    }
}
