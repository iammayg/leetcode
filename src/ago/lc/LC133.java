package ago.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;


public class LC133 {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        //        Node node5 = new Node(5);
        //        node1.addSub(node5);
        Node bfs = bfs(node1);
        System.out.println();
        Node dfs = dfs(node1);
        System.out.println();
    }

    public static Node cloneGraph(Node node) {
        return dfs(node);
    }


    static Map<Node, Node> dfsMap = new HashMap();

    public static Node dfs(Node node) {
        if (node == null) {
            return node;
        }
        if (dfsMap.keySet().contains(node)) {
            return dfsMap.get(node);
        }

        Node cloneNode = new Node(node.val);
        dfsMap.put(node, cloneNode);

        for (Node subNode : node.neighbors) {
            cloneNode.neighbors.add(dfs(subNode));
        }
        return cloneNode;

    }

    //    static Set<Node> st1 = new HashSet<>();
    static Queue<Node> queue = new LinkedList<>();
    static Map<Node, Node> bfsMap = new HashMap();

    public static Node bfs(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        queue.add(node);
        bfsMap.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            for (Node curSubNode : curNode.neighbors) {
                if (!bfsMap.keySet().contains(curSubNode)) {
                    bfsMap.put(curSubNode, new Node(curSubNode.val));
                    queue.add(curSubNode);
                }
                bfsMap.get(curNode).neighbors.add(bfsMap.get(curSubNode));
            }
        }
        return bfsMap.get(node);

    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }
}
