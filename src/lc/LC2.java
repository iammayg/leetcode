package lc;

import java.util.Objects;


public class LC2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode cur = null;
        int n = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2) || n != 0) {
            int n1 = 0;
            int n2 = 0;
            if (Objects.nonNull(l1)) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int sum = n1 + n2+n;
            if (cur == null) {
                res = new ListNode(sum % 10);
                cur=res;
            }else {
                cur.next=new ListNode(sum%10);
                cur=cur.next;
            }
            n = sum / 10;
        }
        return res;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        ListNode n11 = new ListNode(9);
        addTwoNumbers(n11, n1);
    }

    public static class ListNode {
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
