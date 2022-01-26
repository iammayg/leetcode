package num2;

/**
 */
public class LeetCode2 {
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    //解释：342 + 465 = 807.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String reversedNum1 = revers(l1);
        String reversedNum2 = revers(l2);
        int p1 = reversedNum1.length() - 1;
        int p2 = reversedNum2.length() - 1;

        ListNode pre = new ListNode();
        ListNode cur = pre;
        int ys = 0;
        while (p1 >= 0 || p2 >= 0) {
            int cur1 = 0;
            int cur2 = 0;
            if (p1 >= 0) {
                cur1 = Character.getNumericValue(reversedNum1.charAt(p1));
            }
            if (p2 >= 0) {
                cur2 = Character.getNumericValue(reversedNum2.charAt(p2));
            }
            int cursum = cur1 + cur2 + ys;
            cur.next = new ListNode(cursum % 10);
            cur = cur.next;
            ys = cursum / 10;
            p1--;
            p2--;
        }
        if (ys>0){
            cur.next=new ListNode(ys);
        }


        return pre.next;
    }


    static String revers(ListNode head) {
        StringBuilder res = new StringBuilder();
        while (head != null) {
            res.insert(0, head.val);
            head = head.next;
        }
        return res.toString();
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        //        head1.next = new ListNode(4);
        //        head1.next.next = new ListNode(3);
        //1,9,9,9,9,9,9,9,9,9
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next.next = new ListNode(9);
        head2.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next.next.next = new ListNode(9);


        ListNode node = addTwoNumbers(head1, head2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }


    static class ListNode {
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
