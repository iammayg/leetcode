package num2;

public class Leetcode166 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int l1 = 0;
        int l2 = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            p1 = p1.next;
            l1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            l2++;
        }
        p1 = headA;
        p2 = headB;
        while (l1 > l2) {
            p1 = p1.next;
            l1--;
        }
        while (l2 > l1) {
            p2 = p2.next;
            l2--;
        }
        while (p1!=p2&&p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
