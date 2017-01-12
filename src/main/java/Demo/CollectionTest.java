package Demo;


import java.util.*;

/**
 * Created by qiuwei on 2016/12/29.
 */
public class CollectionTest {
    String phone ="18390947988";
    String weixin = phone;



    public static void main(String[] args) {
        String QQ = "2971574460";
        //声明List List是接口 不能实例化
        //ArrayList是List一个实现类 实例化需要实例一个实现类
        List list = new ArrayList();
        List<String> list1 = new ArrayList<String>();

        //add,增加，原来位置往后移一位
        //若List为空时，需要从第一个位置开始增加
        list.add(0,QQ);
        list.add(1,"qiuqiu");
        list.add(2,"shenjie");
        //System.out.println(list.get(0));
        //System.out.println(list.get(2));
        list.add(2,"liuzulin");
        //System.out.println(list.get(2));
        //System.out.println(list.get(3));

        //set(index，Object) --> 替换index位置的元素
        list.set(3,"123");
        //System.out.println(list.get(3));

        //contains,判断集合中是否存在该元素
        //if (list.contains("qiuqiu1")){
        //    System.out.println("包含");
        //}else {
        //    System.out.println("没有包含");
        //}
        //list1.add("list1's Element");

        //for循环list遍历
        //list.addAll(list1);
        //for (int i =0 ; i<list.size();i++){
        //    System.out.println(list.get(i));
        //}
        //list.add("list1's Element");

        //indexOf lastIndexOf
        //List中存在唯一的元素，两个方法返回值相同
        //System.out.println(list.indexOf(list1.get(0)));
        //System.out.println(list.lastIndexOf(list1.get(0)));
        //System.out.println(list.indexOf("qiuqiu"));
        //System.out.println(list.lastIndexOf("qiuqiu"));

        //判空
        //System.out.println(list.isEmpty());
        //list.clear();
        //System.out.println(list.isEmpty());

        //subList(2,4),截取，取头不取尾
        List list2 = list.subList(2,4);

        //迭代器
        // hasNext()-->判断当前位置的下一个位置是否有值
        // next() --> 返回下一个位置的值
        //Iterator iterator = list2.iterator();
        //while(iterator.hasNext()){
        //    System.out.println(iterator.next());
        //}

        //toArray() --> 返回一个Object[]
        //Object[] array = list1.toArray();
        //System.out.println(array[0]);

        //不允许有重复数值，
        //无序数据
        //存放位置的顺序根据hashcode确认
        Set set = new HashSet<String>();
        set.add("qiuqiu");
        set.add("qiuqiu");
        Iterator<String> stringIterator = set.iterator();
        while(stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

        System.out.println(set.hashCode());
        set.addAll(list);
        if (set.isEmpty()){
            System.out.println("set为空");
        }else {
            System.out.println(set);
        }

        Object[] objects = set.toArray();
        System.out.println(objects[2]);

        System.out.println(set.contains("qiuqiu"));

        set.clear();
        System.out.println(set);

    }

}
