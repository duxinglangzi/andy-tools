package junitTest;

import com.alibaba.fastjson.JSON;

/**
 * <p>Description: </p>
 * <p>@Author wuqiong  2018/4/13 </p>
 */
public class Testaaaa {

    public static void main(String[] args) {


        AnswerQuestionsGenerator.QuestionModel[] models = AnswerQuestionsGenerator.generate();
        System.out.println(JSON.toJSONString(models));


    }
}
