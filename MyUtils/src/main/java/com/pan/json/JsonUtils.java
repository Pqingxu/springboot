package com.pan.json;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/13
 */
public class JsonUtils {

    /**
     * web 相应转标准json
     * @param json
     * @return
     */
    public static String webJsonToStand(String json){
        String[] strings = json.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for(String each:strings){
            String[] eachStrings = each.split(":");
            stringBuilder.append("\"").append(eachStrings[0]).append("\":").append(eachStrings[1]).append("\n");
        }
        return stringBuilder.toString();
    }
}
