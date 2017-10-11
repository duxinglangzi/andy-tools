package com.andy.utils;

public class LamdaTest {

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("what ?");
            }
        }).start();



    }




}
