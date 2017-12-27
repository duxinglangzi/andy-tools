package com.andy.codeCollector;


import java.security.MessageDigest;

public class MD5 {

    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4","5", "6", "7", "8", "9",
            "A","B","C","D","E","F","G","I","J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    /**  对字符串进行MD5加密     */
    public static String encodeByMD5(String originString){
        if (originString != null){
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                //String pass =  resultString.toUpperCase();
                return resultString;
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串     */
    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    /**
     * 方法描述:
     * @param args  void
     * @author wuqiong  2014-12-31  下午03:50:17
     */
    public static void main(String[] args) {
        /**
         * 正式使用时可将生成MD5值得数组适当的减少两个字母或数字
         * 这样能大大增加破解的难度
         */
        String str=encodeByMD5("{\"name\":\"小黄牛\",\"sex\":\"男\"}");
        System.out.println(str);
    }


}

