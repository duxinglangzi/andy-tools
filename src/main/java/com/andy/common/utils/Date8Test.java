package com.andy.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Date8Test {

    public static void main(String[] args) {

        System.out.println(LocalDate.now());

        Instant now = Instant.now();
        System.out.println(now.toString());

        System.out.println(LocalDateTime.now());

        System.out.println(LocalTime.now());

        System.out.println(LocalDate.parse("2017-06-23"));

        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        System.out.println(DateFormat.getInstance().format(new Date()));

        JSONObject json = new JSONObject();
        json.put("aa", LocalDateTime.now());
//        json.put("asdfasdf",LocalDateTime.parse("2017-02-13 15:36:42"));

        LocalDateTime localDateTime = LocalDateTime.parse("2017-02-13 15:36:42", DateTimeFormatter.ISO_LOCAL_DATE);
//        SerializeConfig config =new SerializeConfig();
//        config.addFilter();


        System.out.println(JSON.toJSONStringWithDateFormat(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(JSON.toJSONStringWithDateFormat(LocalDate.now(), "yyyy-MM-dd HH:mm:ss"));

        String string = "{\"id\":\"c2643096-7346-4475-bcf6-d1a36f6185df\",\"tenantId\":\"905cf3b7-6696-45a8-9820-83175106340e\",\"dishCode\":\"57008\",\"dishName\":\"332223\"," +
                "\"phoneticCode\":\"332223\",\"fivepenCode\":\"33222\",\"dishProperty\":371,\"dishImg\":\"NO\",\"unitName\":\"支\",\"sortId\":\"0f5a3813-73a2-42e8-907b-7b3b99342d80\"," +
                "\"taxRate\":0.0,\"sellPrice\":1.0,\"membPrice\":1.0,\"theoMargin\":0.0,\"isCommission\":0,\"commMode\":0,\"commNum\":0.0,\"isDiscount\":1,\"isCurPrice\":0,\"isSingle\":1,\"isPriFood\":0," +
                "\"isWeigh\":0,\"isServChange\":0,\"isParRank\":1,\"isTurnover\":1,\"dishHeat\":\"100\",\"dishIngredients\":\"\",\"dishFlavor\":\"\",\"dishCuisine\":\"\",\"dishSort\":100,\"status\":1," +
                "\"createUser\":\"75645b10-9406-4933-9a81-029e800bd529\"," +
                "\"createTime\":1507906958010,\"updateUser\":\"48aab69e-af7c-47df-93fe-1d25b7294359\",\"updateTime\":1507906958010,\"deleteFlag\":1,\"abbrPhon\":\"123\",\"isIntegral\":1," +
                "\"isPractice\":1,\"isSelfMeal\":0,\"isIndiSale\":1,\"pkgAmount\":0.0}";

        System.out.println(string);

        ParserConfig config = ParserConfig.getGlobalInstance();
        config.setAsmEnable(false);
        config.putDeserializer(LocalDateTime.class, LocalDateTimeDeserializer.instance);

        String bdTwo = JSON.parseObject(string, String.class, config, new Feature[0]);


//        BasDish bdTwo =TypeUtils.cast(string,BasDish.class, config);

//        BasDish bdTwo = JSONObject.parseObject(string,BasDish.class);
        System.out.println(JSONObject.toJSONString(bdTwo));


        System.out.println(JSON.toJSONString(json, SerializerFeature.WriteDateUseDateFormat));


    }


}
