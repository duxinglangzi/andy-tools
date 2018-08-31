package com.andy.codeCollector;

import java.util.regex.Pattern;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2018/8/31 </p>
 */
public class StringMobileCheckUtil {

    public static final Pattern mobilePattern = Pattern.compile("^1[3456789][0-9]{9}$");

    // 美国/加拿大
    public static final Pattern usaMobilePattern = Pattern.compile("^1[-. ]?\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$");

    // 沙特阿拉伯   https://gist.github.com/homaily/8672499
    public static final Pattern sarMobilePattern = Pattern.compile("^(00966|966|\\+966)(5|0|3|6|4|9|1|8|7)([0-9]{7})$");

    // 阿拉伯联合酋长国
    public static final Pattern aedMobilePattern = Pattern.compile("^(971|00971|\\+971)(2|3|4|6|7|9|50|51|52|55|56)([0-9]{7})$");

    // 科威特
    public static final Pattern kwMobilePattern = Pattern.compile("^(00965|965|\\+965)(2|3|4|5|6|9)([0-9]{7})$");

    // 阿曼  Oman
    public static final Pattern omMobilePattern = Pattern.compile("^(00968|968|\\+968)(2|9)([1-9]{7})$");

    // 卡塔尔  Qatar
    public static final Pattern qaMobilePattern = Pattern.compile("^(00974|974|\\+974)(30|33|44|55|66|77)([1-9]{6})$");

    // 巴林  Bahrain
    public static final Pattern bhMobilePattern = Pattern.compile("^(00973|973|\\+973)[1-9]{8}$");

    public static void main(String[] args) {
        // 科威特手机号测试
        System.out.println(kwMobilePattern.matcher("0096555323232").matches());
        // 巴林手机号测试
        System.out.println(bhMobilePattern.matcher("0097334667218").matches());
        // 美国/加拿大
        System.out.println(usaMobilePattern.matcher("14084766514").matches());
        // 阿拉伯联合酋长国   543682667
        System.out.println(aedMobilePattern.matcher("00971505407707").matches());
    }

    public static boolean isMobile(String mobile){
        return mobilePattern.matcher(mobile).matches();
    }

    public static boolean isNotMobile(String mobile){
        return !isMobile(mobile);
    }

    public static boolean isSarMobile(String mobile){
        return sarMobilePattern.matcher(mobile).matches();
    }
    public static boolean isAedMobile(String mobile){
        return aedMobilePattern.matcher(mobile).matches();
    }
    public static boolean isUsaMobile(String mobile){
        return usaMobilePattern.matcher(mobile).matches();
    }
    public static boolean isKwMobile(String mobile){
        return kwMobilePattern.matcher(mobile).matches();
    }
    public static boolean isOmMobile(String mobile){
        return omMobilePattern.matcher(mobile).matches();
    }
    public static boolean isBhMobile(String mobile){
        return bhMobilePattern.matcher(mobile).matches();
    }
    public static boolean isQaMobile(String mobile){
        return qaMobilePattern.matcher(mobile).matches();
    }

}
