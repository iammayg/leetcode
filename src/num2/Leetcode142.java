package num2;

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null){
            return null;
        }

        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s=s.next;
            if (f==s){
                break;
            }
        }
        if (s!=f){
            return null;
        }
        s=head;
        while (s!=f){
            s=s.next;
            f=f.next;
        }
        return s;

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
