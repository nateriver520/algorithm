package com.nateriver.app.quiz;

import java.util.Random;

/**
 * 给定能随机生成整数1到5的函数，写出能随机生成整数1到7的函数
 */
public class Random7 {
    public int random5(){
        Random r = new Random();
        return Math.abs(r.nextInt())%5 + 1;
    }

    public int random2(){
        while (true) {
            int temp = random5();
            if(temp <= 2) return temp;
        }
    }

    public int random7(){
        int res = 0;
        while (res == 0){
            res = (random2() -1) << 2;
            res += (random2() -1) << 1;
            res += random2() -1;
        }
        return res;
    }



    public static void main(String[] args) {
        Random7 random7 = new Random7();
        for(int i =0 ; i < 10;i ++){
            System.out.println(random7.random7());
        }
    }
}
