package Demo;


import java.util.*;

/**
 * Created by qiuwei on 2016/12/29.
 */
public class CollectionPractice {
    //    1) 创建一个List，在List 中增加三个工人，基本信息如下：
//    姓名 年龄 工资
//    zhang3 18 3000
//    li4 25 3500
//    wang5 22 3200
//   2) 在li4 之前插入一个工人，信息为：姓名：zhao6，年龄：24，工资3300
//   3) 删除wang5 的信息
//   4) 利用for 循环遍历，打印List 中所有工人的信息
//   5) 利用迭代遍历，对List 中所有的工人调用work 方法。
//   6) 为Worker 类重写equals 方法，当姓名、年龄、工资全部相等时候才返回true
    public static void main(String[] args) {
        //声明三个工人
        person zhang3 = new person("zhang3", "18", "6000");
        person li4 = new person("li4", "25", "5000");
        person wang5 = new person("wang5", "20", "2500");

        //将工人信息添加到List中
        List<person> personList = new ArrayList<person>();

        personList.add(zhang3);
        personList.add(li4);
        personList.add(wang5);

        //在li4之前插入zhao6
        personList.add(1, new person("zhao6", "20", "6000"));
        personList.add(new person("zhao6", "25", "2500"));
        personList.add(new person("zhao6", "20", "2500"));

        //移除wang5
        personList.remove(wang5);

        //使用for循环遍历List
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).printf();
        }

        person zhao = new person("zhao6", "20", "6000");

        //使用迭代器调用work方法
        Iterator<person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            iterator.next().work();
        }

        //使用迭代器对比zhao这个实例化person
        Iterator<person> iterator1 = personList.iterator();
        while (iterator1.hasNext()) {
            zhao.equals(iterator1.next());
        }

        //person对象："name + age + gongzi"
        Map<person,String> map = new HashMap<person, String>();
        map.put(zhang3,"zhang3 18 200");
        map.put(li4,"li4 25 250");
        map.put(wang5,"wang5 30 251");
        System.out.println(map.get(li4));
        if (map.containsKey(wang5)){
            System.out.println(map.get(wang5));
            map.remove(wang5);
        }
        map.put(zhao,"zhao6 66 666");
        System.out.println(map.containsValue("zhao6 66 666"));

        //通过keySet()遍历map
        Iterator<person> ite = map.keySet().iterator();
        while (ite.hasNext()){
            System.out.println(map.get(ite.next()));
        }

        //通过values()遍历
        Iterator<String> ite2 = map.values().iterator();
        while (ite2.hasNext()){
            System.out.println(ite2.next());
        }

        //通过entrySet()遍历
        Iterator<Map.Entry<person,String>> ite3 = map.entrySet().iterator();
        while (ite3.hasNext()){
            System.out.println(ite3.next().getValue());
            //System.out.println(ite3.next().getValue());
        }

    }
}

class person {
    String name = null;
    String age = null;
    String gongzi = null;

    public person(String name, String age, String gongzi) {
        this.name = name;
        this.age = age;
        this.gongzi = gongzi;
    }

    public void printf() {
        System.out.println("--------------");
        System.out.println("姓名 年龄 工资");
        System.out.println(name + " " + age + " " + gongzi + " ");
    }

    public void work() {
        System.out.println("【" + this.name + "】我正在工作，请别打扰我");
    }

    public boolean equals(person person) {
        if (this.name.equals(person.name)) {
            if (this.age.equals(person.age)) {
                if (this.gongzi.equals(person.gongzi)) {
                    System.out.println("相同的姓名，年龄，工资");
                    return true;
                } else {
                    System.out.println("不相同的工资");
                    return false;
                }
            } else {
                System.out.println("不相同的年龄");
                return false;
            }
        } else {
            System.out.println("不相同的姓名");
            return false;
        }
    }

    public boolean isExist(Set set, Object object) {
        boolean isExists = false;
        Iterator iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            Object element = iterator2.next();
            if (object.equals(element)) {
                isExists = true;
            }
        }
        return isExists;
    }

}

