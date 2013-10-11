package com.nateriver.app.utils;


import com.nateriver.app.models.SingleLink;

public class Builder {
    public  static  SingleLink singleLinkBuilder(String[] values){
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
}
