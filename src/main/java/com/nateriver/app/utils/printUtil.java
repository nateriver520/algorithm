package com.nateriver.app.utils;

import com.nateriver.app.models.SingleLink;
import com.nateriver.app.models.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: yangshuo
 * Date: 10/10/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrintUtil {
    public static void printMatrix(Object[][] matrix){
        for(int i =0 ;i < matrix.length; i++){
            Object[] arr = matrix[i];
            for(Object a: arr)
                System.out.print(a.toString()+", ");
            System.out.println();
        }
    }

    public static void printSingleLink(SingleLink head){
        if (head ==null || head.next ==null)
            return;
        SingleLink node = head;
        while (node.next != null){
            SingleLink nextNode = node.next;
            System.out.print(nextNode.value);
            System.out.print(" => ");
            node = node.next;
        }

        System.out.println();

    }


    public static void printTree(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.value + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();

        }

    }

}
