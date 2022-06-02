package com.pan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/16
 */

@SpringBootApplication
//@EnableSwagger2
//@ComponentScan(basePackages = {"com.pan"})//为什么写这个，有的小伙伴扫不到包的请手动扫包
// 扫描mapper接口所在的包
@MapperScan("com.pan.mapper")
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class,args);
    }
}
