package com.nateriver.app.sort;


public class BubbleSort {
    static void sort(int[] a){
        int temp;
        for(int i=0; i<a.length;++i){
            for(int j=a.length-1;j>i;--j){
                if(a[j] <a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }

            }

        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{21, 36, 5, 5, 2, 10, 12, 13, 10, 18, 50};
        sort(numbers);

        for(int i: numbers){
            System.out.print(i + " ");
        }
    }

}
