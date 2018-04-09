package practice.jianzhioffer;


import java.util.Stack;

/**
 * Created by wch on 2018/3/22.
 */
public class Test6 {
    static class ListNode {
        int value;
        ListNode next = null;

        ListNode(int value) {
            this.value = value;
        }

    }

    /**
     * 使用栈实现反序输出
     * 也可以用列表存储，然后反序输出
     *
     * @param listNode
     */
    public void printListFromTailToHead1(ListNode listNode) {
        Stack stack = new Stack();
        if (listNode == null) {
            System.out.println("链表为空");
        }
        while (listNode != null) {
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + "  ");
        }
    }

    /**
     * 使用递归，每访问一个节点，先递归输出它后面的节点，在输出当前节点的值
     *
     * @param listNode
     */
    public void printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead2(listNode.next);
            }
            System.out.print(listNode.value + "  ");
        } else {
            System.out.println("链表为空");
        }
    }

    public void printListFromTailToHead3(ListNode listNode) {
        if (listNode != null) {
            ListNode reverseNode = reverseLinkedList(listNode);
            while(reverseNode != null){
                System.out.print(reverseNode.value+"  ");
                reverseNode = reverseNode.next;
            }
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next == null)
            return head;
        ListNode reversedListNode = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListNode;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        ListNode head = new ListNode(nums[0]);
        ListNode listNode = head;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        Test6 test6 = new Test6();
        test6.printListFromTailToHead1(head);
        test6.printListFromTailToHead2(head);
        test6.printListFromTailToHead3(head);
    }
}
