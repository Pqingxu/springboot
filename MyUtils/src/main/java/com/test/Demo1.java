package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/5/25
 */
public class Demo1 {

    @Test
    public void demo1(){
        String dataJson = "{\"filter\":[{\"opt\":\"eq\",\"category_id_complex\":[\"541\",\"539\",\"540\",\"544\",\"545\",\"547\",\"548\",\"553\",\"551\",\"552\"],\"key\":\"category\"},{\"opt\":\"eq\",\"key\":\"level\",\"level_id_complex\":[\"233\",\"234\",\"235\"]},{\"opt\":\"eq\",\"key\":\"appsys\",\"system_ids\":[\"30\",\"32\",\"33\"]},{\"opt\":\"not eq\",\"net_area_id\":[\"13\",\"16\"],\"key\":\"sip\"},{\"opt\":\"not eq\",\"net_area_id\":[\"12\",\"13\",\"14\"],\"key\":\"dip\"},{\"opt\":\"not eq\",\"value\":[\"1109\",\"119\",\"120\"],\"key\":\"sport\"}],\"detect\":[{\"dict_id\":[\"22\",\"23\",\"24\",\"25\",\"32\",\"34\",\"33\"],\"opt\":\"not eq\",\"preset\":\"base64_decode\",\"key\":\"method\"},{\"dict_id\":[\"23\",\"24\",\"32\",\"33\"],\"opt\":\"eq\",\"preset\":\"\",\"key\":\"method\"},{\"opt\":\"eq\",\"net_area_id\":[\"12\"],\"preset\":\"\",\"key\":\"uri\"},{\"dict_id\":[\"22\",\"24\",\"33\"],\"opt\":\"not eq\",\"preset\":\"suffix\",\"key\":\"request_header@content_type\"},{\"opt\":\"matches\",\"net_area_id\":[\"13\"],\"preset\":\"\",\"key\":\"response_body\"}]}";


        // 符号的hash
        HashMap<String, String> optMap = new HashMap<>();
        optMap.put("eq","等于");
        optMap.put("not eq","不等于");
        optMap.put("contains","包含");
        optMap.put("not contains","不包含");
        optMap.put("gt","大于");
        optMap.put("lt","小于");
        optMap.put("matches","正则匹配");


        // 解析Json
        StringBuffer riskCheckString = new StringBuffer();
        JSONArray detect = JSONObject.parseObject(dataJson).getJSONArray("detect");
        detect.forEach(each-> {
            if (!ObjectUtils.isEmpty(each) && !ObjectUtils.isEmpty(JSONObject.parseObject(String.valueOf(each)).get("key"))
                    && !ObjectUtils.isEmpty(JSONObject.parseObject(String.valueOf(each)).get("opt"))) {
                String[] keys = String.valueOf(JSONObject.parseObject(String.valueOf(each)).get("key")).split("@");
                String key = keys[keys.length - 1];
                String opt = String.valueOf(JSONObject.parseObject(String.valueOf(each)).get("opt"));

                //字典列表
                if (!ObjectUtils.isEmpty(JSONObject.parseObject(String.valueOf(each)).getJSONArray("dict_id"))) {
                    ArrayList dictIdList = JSONObject.parseObject(String.valueOf(each)).getJSONArray("dict_id").toJavaObject(ArrayList.class);
                    riskCheckString.append(" AND (");
                    StringBuffer sb = new StringBuffer();
                    dictIdList.forEach(e -> {
                        sb.append(" ").append(key)
                                .append(optMap.get(opt)).append(String.valueOf(e))
                                .append(" OR");
                    });
                    if(sb.length() > 0){
                        riskCheckString.append(sb.delete(sb.length() - 3,sb.length())).append(" ) ");
                    }
                }

                // 网络区域列表
                if (!ObjectUtils.isEmpty(JSONObject.parseObject(String.valueOf(each)).getJSONArray("net_area_id"))) {
                    ArrayList netAreaIdList = JSONObject.parseObject(String.valueOf(each)).getJSONArray("net_area_id").toJavaObject(ArrayList.class);


                }

                //自定义
                if (!ObjectUtils.isEmpty(JSONObject.parseObject(String.valueOf(each)).getJSONArray("value"))) {
                    ArrayList valueList = JSONObject.parseObject(String.valueOf(each)).getJSONArray("value").toJavaObject(ArrayList.class);


                }
            }
        });
        System.out.println(riskCheckString);
    }
}






