package com.test;

import lombok.Data;

import java.util.List;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/26
 */
@Data
public class Son {
    private String name;
    private Integer age;
    private Integer hobby;
    private List<String> cars;
}
