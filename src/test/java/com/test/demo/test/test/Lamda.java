package com.test.demo.test.test;

import com.test.demo.test.domain.People;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Lamda {

    @Test
    public void testIfPresent(){
        ArrayList<People> list = new ArrayList<>();

        People people1 = new People();
        people1.setName("qqq");
        people1.setAge(11);
        people1.setAddress("河南");
        list.add(people1);

        People people2 = new People();
        people2.setName("www");
        people2.setAge(12);
        people2.setAddress("河北");
        list.add(people2);

        People people3 = new People();
        people3.setName("eee");
        people3.setAge(13);
        people3.setAddress("河西");
        list.add(people3);

        People people4 = new People();
        people4.setName("eee");
        people4.setAge(14);
        people4.setAddress("河西2");
        list.add(people4);


        // TODO findFirst
        Optional<People> first = list.stream().filter(a -> "eee".equals(a.getName())).sorted(Comparator.comparing(People::getAge).reversed()).findFirst();
        System.out.println(first);
        //执行结果： Optional[People{name='eee', age=14, address='河西2'}]

        // TODO ifPresent这个使用的数据类型为Optional
        first.ifPresent(a -> people3.setName("修改了"));
        System.out.println(people3.toString());
    }
}
