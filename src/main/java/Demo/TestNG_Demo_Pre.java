package Demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by qiuwei on 2016/12/26.
 */
public class TestNG_Demo_Pre {
    String name;
    @BeforeTest
    public void prepare(){
        System.out.println("This is zhunbeigongzuo");
    }

    @AfterTest
    public void end(){
        System.out.println("This is shouweigongzuo");
    }

    @Test
    public void print(){
        System.out.println("123");
    }

    @Parameters({"name"})
    @Test
    public void setName(String name){
        this.name = name;
    }

    @Test(dependsOnMethods = "setName")
    public String getName(){
        System.out.println(this.name);
        return this.name;
    }



}
