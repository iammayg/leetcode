package num2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-20
 */
public class Leetcode146 {
    int capacity;
    Map<Integer, LRUNode> map;
    LRUNode l;
    LRUNode r;


    public Leetcode146(int c) {
        capacity = c;
        map = new HashMap<>();
        l = new LRUNode(-1,-1);
        r = new LRUNode(-1,-1);
        l.next = r;
        r.pre = l;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode lruNode = map.get(key);
            remove(lruNode);
            insert(lruNode);
            return lruNode.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode lruNode = map.get(key);
            lruNode.value = value;
            remove(lruNode);
            insert(lruNode);
        } else {
            LRUNode lruNode = new LRUNode(key,value);
            if (map.size() >= capacity) {
                LRUNode toremove = r.pre;
                map.remove(toremove.key);
                remove(toremove);
            }
            insert(lruNode);
            map.put(key, lruNode);
        }
    }

    private void insert(LRUNode lruNode) {
        lruNode.next = l.next;
        lruNode.pre = l;
        l.next.pre = lruNode;
        lruNode.pre.next = lruNode;
    }

    private void remove(LRUNode lruNode) {
        lruNode.pre.next = lruNode.next;
        lruNode.next.pre = lruNode.pre;
    }


    //["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    public static void main(String[] args) {
        Leetcode146 xxx = new Leetcode146(2);
        xxx.put(1, 1);
        xxx.put(2, 2);
        System.out.println(xxx.get(1));
        xxx.put(3, 3);
        System.out.println(xxx.get(2));
        xxx.put(4, 4);
        System.out.println(xxx.get(1));
        System.out.println(xxx.get(3));
        System.out.println(xxx.get(4));

    }


    public static class LRUNode {
        Integer value;
        Integer key;
        LRUNode pre;
        LRUNode next;

        public LRUNode(int key,int value) {
            this.value = value;
            this.key=key;
        }
    }
}
