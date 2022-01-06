package nc;



public class NC78 {
//    public static ListNode ReverseList(ListNode head) {
//        if (head.next==null){
//            return head;
//        }
//        ReverseList(head.next)
//    }

//    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        n1.next = n2;
//        ListNode listNode = ReverseList(n1);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//    }

    //    public ListNode ReverseList(ListNode head) {
    //        ListNode newNode = null;
    //        while (head != null) {
    //            ListNode curNode=new ListNode(head.val);
    //            curNode.next=newNode;
    //            newNode=curNode;
    //            head=head.next;
    //        }
    //        return newNode;
    //    }

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
