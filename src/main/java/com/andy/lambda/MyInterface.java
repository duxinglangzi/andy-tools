package com.andy.lambda;

/**
 * Description: 自定义函数式的接口
 *
 * @author wuqiong 2018-06-19 10:41
 */
public interface MyInterface {

    void interfaceOne();

    void interfaceTwo(String string);

    default String helloWord(String string) {
        return string == null ? "默认的返回字符串" : string;
    }
}
/**
 * <p> 调用时写法如下 </p>
 * <pre>
 *     public static void excuteHelloWord(MyInterface interface,String string){
 *         action.interfaceTwo(string);
 *     }
 *
 *     public static void main(String[] args) {
 *
 *          excuteHelloWord((String s)->System.out.println(s),"Hello world");
 *
 *      }
 * </pre>
 *
 */