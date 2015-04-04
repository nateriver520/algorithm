package com.nateriver.app.quiz;


public class Volatile {
    private static boolean stop = false;


    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            int i = 0;

            @Override
            public void run() {
                while (!stop) {
                    i++;
                    //System.out.println(i);
                }
            }
        };
        t.start();

        Thread.sleep(100);
        stop = true;
        System.out.println("Main: exit");
    }
}
