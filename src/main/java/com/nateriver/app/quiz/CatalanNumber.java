package com.nateriver.app.quiz;


/**
 * Catalan number
 * http://baike.baidu.com/view/2499752.htm?fr=aladdin
 */
public class CatalanNumber {

    int getOutPutStacKNumber(int n){
        if(n == 0 || n == 1) return 1;
        int result = 0;
        for(int i = 0; i< n; i++ ){
            result += getOutPutStacKNumber(i) * getOutPutStacKNumber(n-i -1);
        }

        return result;
    }

    public static void main(String[] args) {
        CatalanNumber catalan = new CatalanNumber();
        System.out.println(catalan.getOutPutStacKNumber(4));
    }
}
