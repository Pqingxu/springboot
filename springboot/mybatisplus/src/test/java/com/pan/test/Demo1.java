package com.pan.test;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/18
 */
public class Demo1 {

    @Test
    public void demo1(){
        int count = 1;
        Assert.isTrue(count==0,"标签名称已存在");
    }
}
