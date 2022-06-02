package com.test;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/5/3
 */
public class Mian {

    @Test
    public void demo(){
        People.HHH hhh = new People.HHH();
        hhh.getName();
    }



    public static Integer timeInterval(Date start, Date end){
        long between = DateUtil.between(start, end, DateUnit.MINUTE);
        if (between > 500  ){
            return Long.valueOf(between/50).intValue();
        }
        return 10;
    }

    @Test
    public void demo2(){
        Date d1 = new Date(500000);
        Date d2 = new Date(500000000);
        System.out.println(timeInterval(d1,d2));


    }


    @Test
    public void demo3(){
        Integer[] tagIdList = new Integer[]{1,2,34,5};
        List<String> collect = Arrays.stream(tagIdList).map(i -> String.valueOf(i)).collect(Collectors.toList());
        System.out.println(collect);



    }

}
