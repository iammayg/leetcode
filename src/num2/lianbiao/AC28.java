package num2.lianbiao;

public class AC28 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //        head.next.next=new ListNode(3);
        //        head.next.next.next=new ListNode(4);
        //        head.next.next.next.next=new ListNode(5);

        ListNode toDeleteNode = head;
        deleteNode(toDeleteNode);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}