package com.test.demo.test.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：miaoqs
 * @date ：2019-07-16 17:22
 * @description：测试
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userName;

    private Integer age;

}
