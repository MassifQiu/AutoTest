package Demo;

/**
 * Created by qiuwei on 2016/12/22.
 */
public class Test1 {
    public Test1() {
    }

    public void set() {

    }

    public static void main(String[] args) {

        int i = 8;
        int j = 5;
        int x = (i & j);
        System.out.println(x);
        //Test1 Part_left_Test = new Test1();
        //取余运算：正负取决于被除数
        x = (i % j);
        System.out.println(x);
        // 先自加1，再赋值
        x = ++i;
        System.out.println("x  =" + x);
        // 先赋值，再自加1
        x = i++;
        System.out.println("x = " + x);
        System.out.println("i = " + i);
        System.out.println(i++);
        System.out.println(j--);
        System.out.println(--j);

        //逻辑运算符
        //boolean类型的默认值是false
        //逻辑运算符，两个操作数，是boolean，
        //&运算
        //|运算
        //短路&&：先看左边的操作数，若操作数为假，则整个结果为假
        //短路||：先看左边的操作数，若操作数为真，则整个结果为真
        boolean str1 = false;
        boolean str2 = true;
        System.out.println("false & true的值为"+(str1 && str2));
        System.out.println("false | true的值为"+(str1 | str2));
        System.out.println("false & false的值为"+(str1 & str1));
        System.out.println("true & true的值为"+(str2 & str2));
        System.out.println("false | true的值为"+(str1 | str2));
        System.out.println("false | false的值为"+(str1 | str1));
        System.out.println("true | true的值为"+(str2 | str2));

        System.out.println((i++>15)&&(j++<10));
    }
}