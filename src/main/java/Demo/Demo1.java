package Demo;

/**
 * Created by qiuwei on 2016/12/23.
 */
public class Demo1 extends Demo{

    public Demo1(){
        super("");
        System.out.println("");
    }


    public void getWeight(){
        System.out.println(name);
        System.out.println(score);
    }

    public void print(){
        setName("曹操");
    }
    public static void main(String[] args) {
        Demo1 test1 = new Demo1();
        test1.getWeight();
    }
}
