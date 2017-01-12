package Demo;

/**
 * Created by qiuwei on 2016/12/23.
 */
public class Demo {
    //1、有哪些类
    //2、每个类的属性和行为
    //3、类与类之间的关系


    //子类的构造方法第一句话必须是父类构造方法引用（super()）
    //若子类没有构造方法，&& 父类中没有无参构造方法，则报错
    //
    String name = "qiuqiu";
    int age = 18;
    private double weight = 0;
    protected int score = 0;

    //public Demo(){
    //    System.out.println(name);
    //}

    public Demo(String name){
        this.name = name;
        System.out.println(this.name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setName(){
        System.out.println(name);
    }

    public void setName( int name ){

    }

    public void addWeight(){
        this.weight++;
    }

    //public static void main(String[] args) {
    //    Demo test = new Demo();
    //}

}
