package Demo;

/**
 * Created by qiuwei on 2016/12/26.
 */
public class Teacher extends People {

    public void say(String str){
        System.out.println(str);
    }

    public void say(){
        System.out.println("我是一名老师");
    }

    public Teacher get(){
        return new Teacher();
    }

    public static void main(String[] args) {
        People QQ = new Teacher();
        QQ.say();
        QQ = new People();
        QQ.say();

    }
}
