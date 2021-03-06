package com.nateriver.app.cracking;

import com.nateriver.app.models.LinkNode;
import com.nateriver.app.utils.Builder;
import com.sun.tools.javac.util.Pair;

/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 *
 * EXAMPLE
 * Input: A –> B –> C –> D –> E –> C [the same C as earlier]
 * Output: C
 */

public class Q25 {

    private static Pair<Boolean,LinkNode> isCircle(LinkNode head){
        LinkNode first = head;
        LinkNode second = head;

        while (second.next != null && second.next.next != null){
            first = first.next;
            second = second.next.next;
            if(first == second)
               return new Pair<>(true,second);
        }

        return new Pair<>(false,null);
    }

    /**
     * First find the point in the loop
     * Then from the loop , head to find the intersect point
     * Detail answer: http://www.cnblogs.com/Jax/archive/2009/12/11/1621504.html
     *
     * Another way is use hash to record every point.
     * Once hash collision, there is the loop point
     */
    public static LinkNode findStartLoop(LinkNode head){

        Pair<Boolean, LinkNode> pair = isCircle(head);
        if(!pair.fst)
            return null;

        LinkNode circlePoint = pair.snd;

        LinkNode curr = head.next;
        LinkNode curr2 = circlePoint.next;

        Integer headToCirclePointLength = 1;
        while (curr != circlePoint){
            curr = curr.next;
            headToCirclePointLength ++;
        }

        Integer circleLength = 1;
        while (curr2 != circlePoint){
            curr2 = curr2.next;
            circleLength ++;
        }

        curr = head.next;
        curr2 = circlePoint.next;

        if(headToCirclePointLength > circleLength){
            for(int i = 0; i < headToCirclePointLength -circleLength; i++)
                curr = curr.next;
        } else{
            for(int i = 0; i < circleLength -headToCirclePointLength; i++)
                curr2 = curr2.next;
        }

        while (curr != curr2){
            curr = curr.next;
            curr2 = curr2.next;
        }

        return curr;
    }


    /**
     *  This is a tricky way to do this.
     *  TODO  need understand more
     */
    public static LinkNode findStartLoop2(LinkNode head){
        Pair<Boolean, LinkNode> pair = isCircle(head);
        if(!pair.fst)
            return null;

        LinkNode circlePoint = pair.snd;

        LinkNode first = head;

        while (first != circlePoint){
            first = first.next;
            circlePoint = circlePoint.next;
        }

        return first;
    }

    public static void main(String[] args) {
        Pair<LinkNode,LinkNode> nodes_1 = Builder.singleLinkCircleBuilder(new String[]{"a", "b", "c", "f", "e", "d", "a"}, 3);
        System.out.println(findStartLoop(nodes_1.fst).value);
        System.out.println(findStartLoop2(nodes_1.fst).value);
    }
}
