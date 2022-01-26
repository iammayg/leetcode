package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-26
 */
public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode();
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode cur = pre;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                if (p1.val < p2.val) {
                    cur.next = p1;
                    p1 = p1.next;
                } else {
                    cur.next = p2;
                    p2 = p2.next;
                }
            }
            cur = cur.next;
        }
        return pre.next;

    }

    public class ListNode {
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
