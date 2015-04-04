package com.nateriver.app.cracking;

import com.nateriver.app.models.LinkNode;
import com.nateriver.app.utils.Builder;
import com.nateriver.app.utils.PrintHelper;
import com.sun.tools.javac.util.Pair;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list
 * given only access to that node.
 * Example: Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class Q23 {
    /**
     * if delNode are middle node, we use replace value to replace node value
     * if delNode is null or point to last, we just return
     */
    public static void deleteNode(LinkNode delNode) {
        //if del node is null or point to last
        if (delNode == null || delNode.next == null)
            return;
        LinkNode next = delNode.next;
        delNode.value = next.value;
        //now delete next node
        delNode.next = next.next;
        next.next = null;
    }

    public static void main(String[] args) {
        //test case 1
        Pair<LinkNode, LinkNode> nodes_1 = Builder.singleLinkBuilder(new String[]{"a", "b", "c", "f", "e", "d", "a"}, 3);
        deleteNode(nodes_1.snd);
        PrintHelper.printSingleLinkWithHead(nodes_1.fst);

        //test case 2
        Pair<LinkNode, LinkNode> nodes_2 = Builder.singleLinkBuilder(new String[]{"a", "b", "c", "f", "e", "d", "a"}, 7);
        deleteNode(nodes_2.snd);
        PrintHelper.printSingleLinkWithHead(nodes_2.fst);
    }
}
