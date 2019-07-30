package com.test.demo.test.test.map;

import org.junit.Test;

import java.util.*;

/**
 * @author ：miaoqs
 * @date ：2019-07-18 14:24
 * @description：测试hashmap的源码
 */

public class HashMapTest {


    /**
     * 用来测试HashMap的源码
     */
    @Test
    public void test01(){

        Map<String, Object> map = new HashMap<>();
        // 添加
        map.put("oo", "这个是我");
        // 修改
        map.put("oo", "这个是我哦怕我吗");
        // 删除
        map.remove("oo");
        System.out.println(map.get("oo"));
        // 查找
        map.put("hh", "我是用来做测试的呀来不来呀");
        Object oo = map.get("hh");
        System.out.println(oo);


    }

    /**
     * 用来测试ArrayList的源码
     */
    @Test
    public void test02(){

        List<String> list = new ArrayList<>();
        // 添加
        list.add("init init ");
        // 获取
        list.get(0);
        // 修改
        list.add(0, "hahah hhah ");
        // 删除
        list.remove(0);

        System.out.println(list.get(0));
    }

    /**
     * 用来测试HashMap的源码
     */
    @Test
    public void test03(){

        List<String> list = new LinkedList<>();
        list.add("LinkedList");

        System.out.println(list.get(0));
    }



}
