package com.nateriver.app.leetcode;

import com.nateriver.app.models.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/clone-graph/
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class CloneGraph {
    private Map<Integer,UndirectedGraphNode> nodeHash = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode copyNode = nodeHash.get(node.label);
        if(copyNode != null) return copyNode;

        copyNode = new UndirectedGraphNode(node.label);
        nodeHash.put(copyNode.label,copyNode);

        for(UndirectedGraphNode neighbor : node.neighbors){
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        node0.neighbors.add(node0);
        node0.neighbors.add(node0);
        CloneGraph cg = new CloneGraph();
        cg.cloneGraph(node0);

        System.out.println("done");
    }
}
