package num2.lianbiao;

public class LC25 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode newEnd = null;
        ListNode newHead = null;

        ListNode start = head;
        while (start != null) {
            int kk = k;
            ListNode end = start;
            while (kk > 1 && end != null) {
                end = end.next;
                kk--;
            }
            ListNode dNHead = null;
            if (end == null) {
                dNHead = start;
                start=null;
            } else {
                ListNode next = end.next;
                end.next = null;
                dNHead = reverse(start);
                start=next;
            }
            ListNode dNEnd = getEnd(dNHead);
            if (newEnd != null) {
                newEnd.next = dNHead;
            }
            newEnd = dNEnd;
            newHead = dNHead;
        }


        return newHead;

    }

    public static ListNode getEnd(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }


    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            next = next.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseKGroup(head, 2);

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
