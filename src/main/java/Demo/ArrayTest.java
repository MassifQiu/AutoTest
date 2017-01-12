package Demo;



import java.util.Scanner;

/**
 * Created by qiuwei on 2016/12/22.
 */
public class ArrayTest {
    public static void main(String[] args){
        int intArray[] = new int[5];
        long total = 0;
        int len = intArray.length;
        // 给数组元素赋值
        System.out.print("请输入" + len + "个整数，以空格为分隔：");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<len; i++){
            intArray[i] = sc.nextInt();
        }
        // 4 5 6 7 8
        //System.out.println(intArray);
        // 计算数组元素的和
        for(int i=0; i<len; i++){
            total += intArray[i];//total = total + intArray[i];
        }
        System.out.println("所有数组元素的和为：" + total);
        System.out.println("123"+"456");

        String str = "12335356";

    }
}
