package com.helloword.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/5/7
 */
@Data
@ToString
public class Person {

    @NotBlank( message = "Person.name 不能为空")
    private String name;

    private Integer age;
}
