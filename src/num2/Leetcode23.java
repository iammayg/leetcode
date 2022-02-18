package num2;

import java.util.PriorityQueue;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-15
 */
public class Leetcode23 {


    /**
     * 优化
     * 每次找多个指针中最小值的时候需要遍历一下多个指针，可以用一个堆来维护多个指针
     */

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        ListNode pre = new ListNode();
        ListNode cur = pre;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode remove = pq.remove();
            cur.next = remove;
            cur = cur.next;
            if (remove.next != null) {
                pq.add(remove.next);
            }
        }
        return pre.next;
    }


    /**
     * 原始做法时间复杂度略高 n*k
     */
    //=============================================================================================================================

    /**
     *
     */
    //    public ListNode mergeKLists(ListNode[] lists) {
    //        ListNode[] next = new ListNode[lists.length];
    //        for (int i = 0; i < lists.length; i++) {
    //            next[i] = lists[i] == null ? null : lists[i].next;
    //        }
    //        ListNode pre = new ListNode();
    //        ListNode cur = pre;
    //        while (true) {
    //            int minp = 0;
    //            int min = Integer.MAX_VALUE;
    //            boolean end = true;
    //            for (int i = 0; i < lists.length; i++) {
    //                if (lists[i] != null && lists[i].val < min) {
    //                    min = lists[i].val;
    //                    minp = i;
    //                    end = false;
    //                }
    //            }
    //            if (end) {
    //                break;
    //            }
    //            cur.next = lists[minp];
    //            cur = cur.next;
    //            lists[minp] = lists[minp].next;
    //        }
    //        return pre.next;
    //    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


