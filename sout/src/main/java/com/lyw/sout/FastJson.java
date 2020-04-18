package com.lyw.sout;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2020-4-14 17:36
 */
public class FastJson {
    //json转map
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "1");
        jsonObject.put("b", "2");
        Map<String, String> map = new HashMap<>();
        map = JSONObject.parseObject(jsonObject.toJSONString(), Map.class);
        System.out.println(map);
    }
}
