package num2;

public class Leetcode234 {
    public static boolean isPalindrome(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        if (f != null) {
            s = s.next;
        }
        s = reverse(s);
        ListNode p1 = head;
        ListNode p2 = s;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                reverse(s);
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        reverse(s);
        return true;
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;

    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(1);
        isPalindrome(listNode);

    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
