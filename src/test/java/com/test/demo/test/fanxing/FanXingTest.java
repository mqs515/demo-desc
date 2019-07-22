package com.test.demo.test.fanxing;

import com.test.demo.domain.ManPeople;
import com.test.demo.domain.People;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ：miaoqs
 * @date ：2019-06-10 20:13
 * @description：测试范性
 */
public class FanXingTest {

    @Test
    public void test01(){
        ArrayList<ManPeople> manPeopleArrayList = new ArrayList<>();
        Collection<People> peopleList = getPeopleList(manPeopleArrayList);
        peopleList.stream().forEach(people -> System.out.println(people));
    }

    private Collection<People> getPeopleList(Collection<? extends People> peoples){
        return null;
    }
}
