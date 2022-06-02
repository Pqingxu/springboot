package com.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/26
 */
public class Main {

    @Test
    public void demo1(){
        Father father = new Father();
        father.setAge(100);
        father.setName("father");
        father.setHobby("11111");
        father.setCars(Arrays.asList("OOOO","ajsdjaslkd"));

        Son son = new Son();
        BeanUtils.copyProperties(father,son,"age");
        System.out.println(son);
    }

    @Test
    public void demo2(){
        System.out.println(checkType(Arrays.asList("123a","2312","232"),CHECK_TYPE.INTEGER));

    }

    enum CHECK_TYPE{
        STRING,
        LONG,
        INTEGER,
        DOUBLE
    }

    /**
     * 基础类型转换判断工具
     * @param src
     * @param type
     * @return
     */
    public static boolean checkType(Object src,Object type){
        if(ObjectUtils.isEmpty(src) || ObjectUtils.isEmpty(type)){
            return false;
        }
        // 尝试转化
        try{
            if (type == CHECK_TYPE.STRING){
                if ( src instanceof List){
                    ((List<?>) src).forEach(String::valueOf);
                }else {
                    String.valueOf(src);
                }
                return true;
            }else if(type == CHECK_TYPE.LONG){
                if ( src instanceof List){
                    ((List<?>) src).forEach(each->Long.valueOf(String.valueOf(each)));
                }else{
                    Long.valueOf(String.valueOf(src));
                }
                return true;
            }else if(type == (CHECK_TYPE.INTEGER)){
                if ( src instanceof List){
                    ((List<?>) src).forEach(each->Integer.valueOf(String.valueOf(each)));
                }else{
                    Integer.valueOf(String.valueOf(src));
                }
                return true;
            }else if(type == (CHECK_TYPE.DOUBLE)){
                if ( src instanceof List){
                    ((List<?>) src).forEach(each->Double.valueOf(String.valueOf(each)));
                }else{
                    Double.valueOf(String.valueOf(src));
                }
                return true;
            }else {
                Assert.isTrue(false,"checkType 类型检测传参,不存在的类型");
                return false;
            }
        }catch (Exception e){
            // 获得对象类型和名称
            String className = src.getClass().getName();
            className = className.substring(className.lastIndexOf(".")+1);
            Assert.isTrue(false,"类型转换出错："+className+"( "+src+" )-->"+type.toString()+" 错误");
        }
        return true;
    }


    @Test
    public void demo3(){
        List<String> strings = stringToListByCk("['a','API_BQ1']");
        System.out.println(strings);
    }

    /**
     * clickHouse字符数组->List<String>
     *     E.G. "['a','API_BQ1']" -> List
     * @param data
     * @return
     */
    public static List<String> stringToListByCk(String data){
        if (ObjectUtils.isEmpty(data)){
            return null;
        }

        String[] split = data.replace("[", "")
                .replace("]", "")
                .replace("'", "")
                .split(",");
        return Arrays.asList(split).stream().map(String::trim).collect(Collectors.toList());
    }

}
