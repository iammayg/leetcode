package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class JZ22 {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p1 = head;
        ListNode p2 = head;
        while (k > 0) {
            k--;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;// 1 2 3 4 5
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
