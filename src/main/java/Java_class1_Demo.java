public class Java_class1_Demo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;

        int x = 10;
        int y = 21;
        int z = 10;

        //从低精度向高精度转换byte,short,char-> int -> long -> float -> double
        //低精度到高精度会自动转换，而高精度到低精度则要类型强制转换。
        int i;
        double j;
        //高精度转化为低精度，丢失精度
        i = (int) 34.56 + (int) 11.2;
        //低精度强制转化为高精度，提高精度
        j = (double) i + (double) 10 + 1;
        System.out.println("x=" + i);
        System.out.println("y=" + j);


        //a++,先赋值再自加；++a，先自加再赋值
        System.out.println("后自加 a=" + (a++));
        System.out.println("a的值 a=" + a);
        System.out.println("前自加 b=" + (++b));
        //取余%
        System.out.println("取余运算 " + 7 % 2);
        System.out.println("取余运算 " + 60 % 70);

        //关系运算符
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("说 x>y,对吗？" + (x > y));
        //与&，或|，两个操作数都需要比较
        //短路与&&，短路或||：若左边操作数出现问题，则不判断右操作数
        System.out.println("认为 x>y 并且 x<y,对吗？" + ((x > y) && (x < y)));
        System.out.println("认为 x>=y 或者 x==y,对吗？" + ((x >= y) || (x == y)));
        System.out.println("认为 x<y 或者 x=z,对吗？" + ((x < y) || (x == z)));

        //三目运算符：条件式 ？成功返回值 ：失败返回值
        String return1 = "x>y";
        String return2 = "x<y";
        x = 12;
        y = 11;
        String name = x > y ? return1 : return2;
        System.out.println(name);

        if (x > y) {
            System.out.println("x>y");
        } else {
            System.out.println("x<y");
        }

        int sum = 0;
        while (x <= 20) {
            sum = sum + x;
            x++;
            System.out.println(sum);
        }

        for (int n = 0; n <= 10; n++) {

        }

    }
}
