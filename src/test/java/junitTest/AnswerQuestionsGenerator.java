package junitTest;


import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.fastjson.JSON;

public class AnswerQuestionsGenerator {

    private static int numbers = 40;

    /**
     * <pre>
     * 时间范围 0-3秒，0-3000毫秒 分四个档次 3秒 2-3 秒 1-2秒 1秒以下 数字范围 1 - 50；分三个档次： 1-10 11-20 21-50
     * 第一组的题都是 1-20 最后一组的题都在 31-50 ， 中间三组，每组2个，其中第一个在 21-40，第二个 1-30 时间分组
     * 每5个数字为一组共8组，使用同样的时间，其中第一组的时间给 3 秒，最后一组时间在 1 秒以内，其他的分三组，每组2个，其中第一个在 2-3秒，第二个在 1-2秒
     * </pre>
     */

    private AnswerQuestionsGenerator() {
    }

    public static QuestionModel[] generate() {
        QuestionModel[] qms = new QuestionModel[numbers];
        int index = 0;
        for (int i = 1; i < 9; i++) {
            qms[index++] = generate(i, index);
            qms[index++] = generate(i, index);
            qms[index++] = generate(i, index);
            qms[index++] = generate(i, index);
            qms[index++] = generate(i, index);
        }
        return qms;

    }

    public static String convertQuestions2DbStr(QuestionModel[] questions) {
        StringBuilder sb = new StringBuilder(1000);

        /**
         * 格式 n1:n2:ex:r:t:ms;...;n1:n2:ex:r:t:ms;
         */

        for (QuestionModel m : questions) {
            sb.append(m.getN1()).append(":")
                    .append(m.getN2()).append(":")
                    .append(m.getEx()).append(":")
                    .append(m.getR()).append(":")
                    .append(m.getT()).append(":")
                    .append(m.getMs()).append(";");
        }
        return sb.toString();
    }

    private static QuestionModel generate(int group, int index) {

        int numberSeek = 20;
        int numberbase = 1;
        int times = 3000;
        switch (group) {
            case 8:
                numberSeek = 20;
                numberbase = 31;
                times = (ThreadLocalRandom.current().nextInt(9) + 1) * 100;
                break;
            case 2:
            case 4:
            case 6:
                numberSeek = 20;
                numberbase = 21;
                times = (ThreadLocalRandom.current().nextInt(10) + 20) * 100;
                break;
            case 3:
            case 5:
            case 7:
                numberSeek = 30;
                numberbase = 1;
                times = (ThreadLocalRandom.current().nextInt(10) + 10) * 100;
                break;
            default:
                break;
        }

        // 数字1
        int n1 = ThreadLocalRandom.current().nextInt(numberSeek) + numberbase;
        // 数字2
        int n2 = ThreadLocalRandom.current().nextInt(numberSeek) + numberbase;
        // 算术符，随机数为1则是+，随机数是0则是-
        int exn = ThreadLocalRandom.current().nextInt(2);
        String ex = "+";
        if (exn == 0) {
            ex = "-";
        }

        if ("-".equals(ex) && n1 < n2) {
            int t = n1;
            n1 = n2;
            n2 = t;
        }

        // 表达式右边的数，则里有3种情况：0,1-正常；2-相反；3-随机 范围在两个数相加和两个数相减之间，最后取绝对值
        int rn = ThreadLocalRandom.current().nextInt(4);
        int r = 0;
        if (rn < 2) {
            // 给正确答案
            if ("-".equals(ex)) {
                r = n1 - n2;
            } else {
                r = n1 + n2;
            }
        } else if (rn == 2) {
            // 给相反答案
            if ("-".equals(ex)) {
                r = n1 + n2;
            } else {
                r = n1 - n2;
            }
        } else if (rn == 3) {
            // 给随机答案
            int b = Math.abs(n1 - n2);
            r = ThreadLocalRandom.current().nextInt(n1 + n2 - b) + b;
        }
        if (r < 0) {
            r = 0 - r;
        }

        int t = 0;
        if ("-".equals(ex) && (n1 - n2 == r)) {
            t = 1;
        } else if ("+".equals(ex) && (n1 + n2 == r)) {
            t = 1;
        }

        QuestionModel questionModel = new QuestionModel();
        questionModel.setEx(ex);
        questionModel.setMs(times);
        questionModel.setN1(n1);
        questionModel.setN2(n2);
        questionModel.setR(r);
        questionModel.setT(t);
        questionModel.setIdx(index);
        questionModel.setPs(100);
        return questionModel;

    }

    public static void main(String[] args) {
        QuestionModel[] generate = generate();
        System.out.println(JSON.toJSONString(generate));
        System.out.println(convertQuestions2DbStr(generate));
    }

    public static class QuestionModel {

        /**
         * 左数1
         */
        private int n1;
        /**
         * 左数2
         */
        private int n2;
        /**
         * 表达式 + -
         */
        private String ex;
        /**
         * 右边的数
         */
        private int r;

        /**
         * 答案是对还是错 0-错，1-对
         */
        private int t;
        /**
         * 答案时间，毫秒数
         */
        private int ms;

        private int idx;
        private int ps;

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getN1() {
            return n1;
        }

        public void setN1(int n1) {
            this.n1 = n1;
        }

        public int getN2() {
            return n2;
        }

        public void setN2(int n2) {
            this.n2 = n2;
        }

        public String getEx() {
            return ex;
        }

        public void setEx(String ex) {
            this.ex = ex;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        public int getMs() {
            return ms;
        }

        public void setMs(int ms) {
            this.ms = ms;
        }

    }
}


