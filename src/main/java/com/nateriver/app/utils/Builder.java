package com.nateriver.app.utils;


import com.nateriver.app.models.LinkNode;
import com.sun.tools.javac.util.Pair;

public class Builder {
    public static LinkNode singleLinkBuilderWithHead(String[] values){
        LinkNode head = new LinkNode();
        LinkNode node = head;
        for(String value : values ){
            LinkNode tempNode = new LinkNode();
            tempNode.value = value;

            node.next = tempNode;
            node = node.next;
            node.next = null;
        }
        return head;
    }

    public static LinkNode singleLinkBuilderWithNoHead(String[] values){
        LinkNode head = new LinkNode();
        head.value = values[0];
        LinkNode node = head;
        for(int i= 1; i< values.length; i++){
            LinkNode tempNode = new LinkNode();
            tempNode.value = values[i];
            node.next = tempNode;
            node = node.next;
            node.next = null;
        }
        return head;
    }


    public static Pair<LinkNode,LinkNode> singleLinkBuilder(String[] values, Integer position){
        LinkNode head = new LinkNode();
        LinkNode node = head;
        LinkNode positionNode =  new LinkNode();

        if(position > values.length)
            return null;

        Integer index = 0;
        for(String value : values ){
            LinkNode tempNode = new LinkNode();
            tempNode.value = value;
            node.next = tempNode;
            node = node.next;
            node.next = null;
            index ++;
            if(index.equals(position))
                positionNode = tempNode;
        }
        return new Pair<>(head,positionNode);
    }

    public static Pair<LinkNode,LinkNode> singleLinkCircleBuilder(String[] values, Integer position){
        LinkNode head = new LinkNode();
        LinkNode node = head;
        LinkNode positionNode =  new LinkNode();
        LinkNode endPoint = new LinkNode();

        if(position > values.length)
            return null;

        Integer index = 0;

        for(String value : values ){
            LinkNode tempNode = new LinkNode();
            tempNode.value = value;
            node.next = tempNode;
            node = node.next;
            node.next = null;
            index ++;
            if(index.equals(position))
                positionNode = tempNode;
            if(index == values.length)
                endPoint = tempNode;
        }

        endPoint.next = positionNode;

        return new Pair<>(head,positionNode);
    }
}
