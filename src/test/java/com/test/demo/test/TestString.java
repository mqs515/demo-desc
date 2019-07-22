package com.test.demo.test;

import com.test.demo.domain.User;
import org.junit.Test;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author ：miaoqs
 * @date ：2019-05-30 15:19
 * @description：list转换成以逗号分隔的字符串
 */
public class TestString {

    @Test
    public void test01(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        String join = String.join(",", list);
        System.out.println(join);

        String ids = "1,2,3,4";
        List<String> asList = Arrays.asList(ids.split(","));
        System.out.println(asList);

    }

    @Test
    public void testTo(){
        String strs = "sssss,ee,rr,ww";


        String[] strings = StringUtils.commaDelimitedListToStringArray(strs);

        String s = StringUtils.arrayToCommaDelimitedString(strings);

        System.out.println(Arrays.asList(strings) + "===" + s) ;


    }

    @Test
    public void testNull(){
        Integer sort = null;
        if (Objects.equals(sort, 1)){
            System.out.println(111);
            return;
        }
    }

    @Test
    public void testNull1(){
//        User build = User.builder().userName(null).age(11).build();
        User user = new User();
        user.setUserName(null);
        user.setAge(11);
        System.out.println(user);

    }

    @Test
    public void test02(){
        int a = 5;
        if (a < 0)
            System.out.println(a);
        else if (a > 10){
            System.out.println(a);
        }else {
            System.out.println(a);
        }
    }
}
