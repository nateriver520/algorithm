package com.nateriver.app.utils;

import com.nateriver.app.models.LinkNode;
import com.nateriver.app.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: yangshuo
 * Date: 10/10/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrintHelper {
    public static void printMatrix(Object[][] matrix){
        for (Object[] arr : matrix) {
            for (Object a : arr)
                System.out.print(a.toString() + ", ");
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int[] arr : matrix) {
            for (int a : arr)
                System.out.print(a + ", ");
            System.out.println();
        }
        System.out.println();
    }

    public static void printSingleLinkWithHead(LinkNode head){
        if (head ==null || head.next ==null)
            return;
        LinkNode node = head;
        while (node.next != null){
            LinkNode nextNode = node.next;
            System.out.print(nextNode.value);
            System.out.print(" => ");
            node = node.next;
        }

        System.out.println();

    }

    public static void printSingleLinkWithNoHead(LinkNode head){
        if (head ==null)
            return;
        LinkNode node = head;
        System.out.print(node.value);
        System.out.print(" => ");

        while (node.next != null){
            LinkNode nextNode = node.next;
            System.out.print(nextNode.value);
            System.out.print(" => ");
            node = node.next;
        }

        System.out.println();

    }


    public static void printTree(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            for (TreeNode currentNode : currentLevel) {
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
