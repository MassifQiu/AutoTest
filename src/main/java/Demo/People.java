package Demo;

/**
 * Created by qiuwei on 2016/12/26.
 */
public class People {
    public void say(){
        System.out.println("我是一个人");
    }

    protected People get(){
        return new People();
    }

}
