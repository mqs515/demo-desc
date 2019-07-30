package com.test.demo.test.test.fanxing;

import com.test.demo.test.domain.ManPeople;
import com.test.demo.test.domain.People;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：miaoqs
 * @date ：2019-06-10 20:13
 * @description：测试范性
 */
public class FanXingTest {

    @Test
    public void test01(){

        ManPeople p1 = new ManPeople();
        p1.setName("lisi");
        p1.setAddress("hangzhou");
        p1.setAge(20);

        ArrayList<ManPeople> manPeopleArrayList = new ArrayList<>();
        manPeopleArrayList.add(p1);

        if (manPeopleArrayList.isEmpty()){
            System.out.println("集合没有书籍----范性测试失败哦");
            return;
        }

        Collection<People> peopleList = getPeopleList(manPeopleArrayList);
        peopleList.stream().forEach(people -> System.out.println(people));
    }

    private Collection<People> getPeopleList(Collection<? extends People> peoples){
        Collection<People> coll = new ArrayList<>();
        List<People> collect = peoples.stream().map(p -> {
            People people = new People();
            BeanUtils.copyProperties(p, people);
            return people;
        }).collect(Collectors.toList());

        coll.addAll(collect);
        return coll;
    }
}
