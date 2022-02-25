package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-25
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

    }
}
