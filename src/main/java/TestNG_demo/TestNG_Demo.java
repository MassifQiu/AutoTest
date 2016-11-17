package TestNG_demo;

import org.testng.annotations.*;

/**
 * Created by qiuwei on 2016/11/11.
 */

public class TestNG_Demo {
    @BeforeTest
    public void beforeTest(){
        System.out.println("This is BeforeTest");
    }

    @Test(dependsOnMethods = "test2" ,alwaysRun = true)
    public void test(){
        System.out.println("This is Test");
    }

    @Test(groups = "test")
    public void test2(){
        System.out.println("This is Test2");
    }

    @Test
    public  void test3(){
        System.out.println("This is Test3");
    }
    @BeforeGroups()
    public void beforeGroups(){
        System.out.println("This is BeforeGroups");
    }

    @AfterGroups()
    public  void afterGroups(){
        System.out.println("This is AfterGroups");
    }


    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("This is afterTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("This is beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is afterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is afterMethod");
    }

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("This is beforeSuit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("This is afterSuit");

    }}
