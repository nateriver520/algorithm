package com.nateriver.app.utils;


import com.nateriver.app.models.SingleLink;
import com.sun.tools.javac.util.Pair;

public class Builder {
    public static SingleLink singleLinkBuilder(String[] values){
        SingleLink head = new SingleLink();
        SingleLink node = head;
        for(String value : values ){
            SingleLink tempNode = new SingleLink();
            tempNode.value = value;

            node.next = tempNode;
            node = node.next;
            node.next = null;
        }
        return head;
    }

    public static Pair<SingleLink,SingleLink> singleLinkBuilder(String[] values, Integer position){
        SingleLink head = new SingleLink();
        SingleLink node = head;
        SingleLink positionNode =  new SingleLink();

        if(position > values.length)
            return null;

        Integer index = 0;
        for(String value : values ){
            SingleLink tempNode = new SingleLink();
            tempNode.value = value;
            node.next = tempNode;
            node = node.next;
            node.next = null;
            index ++;
            if(index == position)
                positionNode = tempNode;
        }
        return new Pair<SingleLink, SingleLink>(head,positionNode);
    }

    public static Pair<SingleLink,SingleLink> singleLinkCircleBuilder(String[] values, Integer position){
        SingleLink head = new SingleLink();
        SingleLink node = head;
        SingleLink positionNode =  new SingleLink();
        SingleLink endPoint = new SingleLink();

        if(position > values.length)
            return null;

        Integer index = 0;

        for(String value : values ){
            SingleLink tempNode = new SingleLink();
            tempNode.value = value;
            node.next = tempNode;
            node = node.next;
            node.next = null;
            index ++;
            if(index == position)
                positionNode = tempNode;
            if(index == values.length)
                endPoint = tempNode;
        }

        endPoint.next = positionNode;

        return new Pair<SingleLink, SingleLink>(head,positionNode);
    }
}
