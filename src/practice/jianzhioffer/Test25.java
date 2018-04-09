package practice.jianzhioffer;


/**
 * Created by wch on 2018/3/28.
 */
public class Test25 {
    static class ListNode {
        int value;
        ListNode next = null;

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append('[');
            ListNode listNode = this;
            while (listNode != null) {
                sb.append(listNode.value);
                sb.append(", ");
                listNode = listNode.next;

            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(']');
            return sb.toString();
        }
    }

    /**
     * 归并排序思路
     * 代码不够简洁
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSortedList1(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode mergedHead;
        if (head1.value < head2.value) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }
        ListNode newNode = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                newNode.next = head1;
                head1 = head1.next;
                newNode = newNode.next;
            } else {
                newNode.next = head2;
                head2 = head2.next;
                newNode = newNode.next;
            }
        }
        if (head1 == null) {
            newNode.next = head2;
        } else {
            newNode.next = head1;
        }
        return mergedHead;
    }

    /**
     * 递归思路
     * 代码简洁，思路清晰
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSortedList2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode mergedHead;
        if (head1.value <= head2.value) {
            mergedHead = head1;
            mergedHead.next = mergeSortedList2(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeSortedList2(head1, head2.next);
        }
        return mergedHead;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode p1 = head1;
        ListNode p2 = head2;
        for (int i = 3; i < 10; i += 2) {
            ListNode listNode1 = new ListNode(i);
            p1.next = listNode1;
            p1 = p1.next;
            ListNode listNode2 = new ListNode(i + 1);
            p2.next = listNode2;
            p2 = p2.next;
        }
        System.out.println(head1.toString());
        System.out.println(head2.toString());
//        ListNode mergedHead1 = mergeSortedList1(head1, head2);
//        System.out.println(mergedHead1.toString());
        ListNode mergedHead2 = mergeSortedList2(head1, head2);
        System.out.println(mergedHead2.toString());
        System.out.println(head1.toString());
        System.out.println(head2.toString());
    }


}
