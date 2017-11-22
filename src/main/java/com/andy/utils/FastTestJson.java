package com.andy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;

import java.time.LocalDateTime;

/**
 * <p>ClassName: 用来测试json序列化 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/11/21 15:03 </p>
 */
public class FastTestJson {

    public static void main(String[] args) {

        String string = "{\"createTime\":1511248447740,\"updateTime\":1511248473134,\"userTime\":\"2017-11-11 14:16:33\"}";

        ParserConfig config = ParserConfig.getGlobalInstance();
        config.setAsmEnable(false);
        config.putDeserializer(LocalDateTime.class, LocalDateTimeDeserializer.instance);

        String bdTwo = JSON.parseObject(string, String.class, config, new Feature[0]);

        User user = JSONObject.parseObject(string, User.class);

        System.out.println(JSONObject.toJSONString(user));
    }


}
