package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-01-27
 */
public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur;
        ListNode next;

        while (pre.next != null && pre.next.next != null) {
            cur = pre.next;
            next = pre.next.next;

            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
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
