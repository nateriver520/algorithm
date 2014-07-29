package com.nateriver.app.quiz;


public class BSTTree {

    /**
     * Given n, how many structurally uniqueBST's (binary search trees) that store values 1...n?
     */
    int getNumbersOfBstTree(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        int i;
        int result = 0;
        for(i = 2; i < n; i++)
            result += getNumbersOfBstTree(i - 1) * getNumbersOfBstTree(n - i);
        return result + 2 * getNumbersOfBstTree(n - 1);
    }

    public static void main(String[] args) {
        BSTTree bstTree = new BSTTree();
        System.out.println(bstTree.getNumbersOfBstTree(3));
    }
}
