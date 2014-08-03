package com.nateriver.app.quiz;

import java.util.LinkedList;
import java.util.Queue;


public class AscendingPrint {
    public static void main(String args[]){

        int n=5;
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();

        q2.add(2);
        q3.add(3);
        q5.add(5);

        int val;
        for(int i = 0;i< Math.pow(n,3);i++){
            val= Math.min(Math.min(q2.peek(),q3.peek()),q5.peek());
            System.out.println(""+val+" "+q2.size()+" "+q3.size()+" "+q5.size());
            if(val == q5.peek()){
                q5.remove();
            }else{
                if(val == q3.peek()){
                    q3.remove();
                }else{
                    q2.remove();
                    q2.add(val*2);
                }
                q3.add(val*3);
            }

            q5.add(val*5);
        }
    }
}


