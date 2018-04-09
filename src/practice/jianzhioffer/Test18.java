package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/26.
 */

/**
 * O(1)的时间删除链表元素
 *
 * 对无头指针的链表操作，一般先新建一个头结点指针（一个指向头结点的节点），最后返回头指针的next
 */
public class Test18 {


    static class ListNode{
        int value;
        ListNode next = null;
        ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode delete(ListNode head,ListNode toBeDeleted){
        if(head == null || toBeDeleted == null){
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        if(toBeDeleted.next != null){ //要删除的节点不是尾结点

            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        } else { //删除的是尾节点
            ListNode listNode = preHead;
            while (listNode.next != toBeDeleted) {
                listNode = listNode.next;
            }
            listNode.next = null;
        }
        return preHead.next;

    }

    public static void print(ListNode head){
        if(head == null){
            System.out.println("list is null");
        }
        while(head != null){
            System.out.print(head.value);
            System.out.print("\t");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        //测试代码
        ListNode head = null;
        head =delete(head, head);
        System.out.println("测试删除空链表头节点");
        print(head);
        head = new ListNode(0);
        ListNode p = head;

        //(3)只有一个结点，删除尾结点(也是头结点)

        head = delete(head, head);
        System.out.println("测试删除尾结点也是头节点的情况");
        print(head);
        head = new ListNode(0);
        p = head;
        for(int i = 1; i < 5; i++){

            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }

        ListNode tail = new ListNode(5);
        p.next = tail;

        System.out.println("输出多元素完整链表");
        print(head);

        head = delete(head, head);
        System.out.println("测试删除头结点后");
        print(head);

        //(2)多个结点，删除尾结点
        head = delete(head, tail);
        System.out.println("接着测试删除尾节点");
        print(head);

        //(1)删除的不是尾结点
        head = delete(head, head.next);
        System.out.println("接着测试删除中间节点");
        print(head);



    }
}
