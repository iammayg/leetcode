package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-26
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;

        ListNode p1 = pre;
        ListNode p2 = pre;

        while (n > 0) {
            p1 = p1.next;
            n--;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;

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

