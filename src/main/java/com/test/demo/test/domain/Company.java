package com.test.demo.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：miaoqs
 * @date ：2019-07-22 13:52
 * @description：公司
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private String name;

    private Job job;

    /**
     * 拷贝的构造方法
     * @param company
     */
    public Company(Company company){
        this.name = company.name;
        this.job = company.job;
    }
}
