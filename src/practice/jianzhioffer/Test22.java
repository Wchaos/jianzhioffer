package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/27.
 */

/**
 * 单向链表寻找倒数第K个值
 */
public class Test22 {
    static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode findKthFromTail(ListNode head, int k){
        if(head == null||k<= 0){
            return null;
        }

        ListNode node1 = head,node2 = head;
        for (int i = 0; i < k-1; i++) {
            if(node1.next != null){
                node1 = node1.next;
            }else{
                return null; // 链表节点数小于k
            }
        }
        while(node1.next != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

}
