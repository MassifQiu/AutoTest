package Demo;

import java.util.*;

/**
 * Created by qiuwei on 2016/12/29.
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("qiuqiu");
        stringList.add("qiuwei");
        stringList.add("weiwei");

        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        Set<String> set = new HashSet<String>();
        set.add("qiuqiu1");
        set.add("qiuwei1");
        set.add("weiwei1");
        Iterator iterator1 = set.iterator();
        String o = "qiuqiu";
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(o)) {
                System.out.println("元素已经存在");
                return;
            } else if (iterator.hasNext()) {
                continue;
            }else {
                set.add(o);
            }
        }
        System.out.println(set);
    }
}
