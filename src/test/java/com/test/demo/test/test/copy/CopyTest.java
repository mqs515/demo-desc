package com.test.demo.test.test.copy;

import com.test.demo.test.domain.Company;
import com.test.demo.test.domain.Job;
import org.junit.Test;

/**
 * @author ：miaoqs
 * @date ：2019-07-22 13:48
 * @description：深拷贝和浅拷贝
 *
 *
 * TODO 基本数据类型是值传递，所以修改值后不会影响另一个对象的该属性值；
 *
 * TODO 引用数据类型是地址传递（引用传递），所以修改值后另一个对象的该属性值会同步被修改。
 *
 * TODO String类型属于引用数据类型，不属于基本数据类型，但是String类型的数据是存放在常量池中的，也就是无法修改的！
 */
public class CopyTest {

    /**
     * 测试浅拷贝
     * TODO 一般的实现方法 拷贝构造
     */
    @Test
    public void testQCopy(){
        Job job = new Job(20);

        Company c = new Company("aa", job);

        Company company = new Company(c);

        System.out.println(c.toString());
        System.out.println(company.toString());
        // 修改c的属性莞产company的变化
        c.setName("bb");
        job.setMoney(33);

        System.out.println(c.toString());
        System.out.println(company.toString());
    }

    /**
     * 测试浅拷贝
     * TODO 实现Cloneable接口拷贝
     */
    @Test
    public void testTQCopy(){
        Job job = new Job(20);

        Student stu = new Student("aa", job, 110);

        //通过调用重写后的clone方法进行浅拷贝
        Student stu2 = null;
        try {
            stu2 = (Student) stu.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(stu.toString());
        System.out.println(stu2.toString());
        // 修改c的属性莞产company的变化
        stu.setName("bb");
        job.setMoney(33);
        stu.setLength(120);

        System.out.println(stu.toString());
        System.out.println(stu2.toString());
    }
}
