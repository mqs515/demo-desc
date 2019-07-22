package com.test.demo.test.copy;

import com.test.demo.domain.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：miaoqs
 * @date ：2019-07-22 14:23
 * @description：学生
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Cloneable{

    private String name;

    private Job job;

    private int length;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}
