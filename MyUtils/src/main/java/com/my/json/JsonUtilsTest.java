package com.my.json;

import com.pan.json.JsonUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/13
 */
public class JsonUtilsTest {

    @Test
    public void demo1(){
        String demoStr = "appPolicy: null\n" +
                "createdTime: \"2022-04-13 11:02:10\"\n" +
                "createdUser: \"prsadmin\"\n" +
                "id: 14\n" +
                "tagDesc: \"系统应用标签bug测试\"\n" +
                "tagName: \"标签bug特殊符号测试 -！@#%￥%……%&…… - 次数2\"\n" +
                "tagType: 1\n" +
                "tagTypeName: null\n" +
                "updateUser: \"prsadmin\"\n" +
                "updatedTime: \"2022-04-13 11:02:10\"\n" +
                "useCount: 0";

        System.out.println(JsonUtils.webJsonToStand(demoStr));
    }
}
