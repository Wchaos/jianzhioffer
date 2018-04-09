package practice.jianzhioffer;

/**
 * Created by wch on 2018/4/3.
 */

/**
 *  两个链表的第一个公共节点
 */
public class Test52 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if(pHead1 == null||pHead2 == null){
                return null;
            }
            int length1 = getListLength(pHead1);
            int length2 = getListLength(pHead2);

            ListNode longListNode = pHead1;
            ListNode shortListNode = pHead2;
            int lenDiff = length1-length2;

            if(length1<length2){
                longListNode = pHead2;
                shortListNode = pHead1;
                lenDiff = length2-length1;
            }
            for (int i = 0; i < lenDiff; i++) {
                longListNode = longListNode.next;
            }
            while(longListNode!=null&&shortListNode!=null){
                if(longListNode == shortListNode){
                    return longListNode;
                }
                longListNode = longListNode.next;
                shortListNode= shortListNode.next;
            }
            return null;
        }
        private static int getListLength(ListNode pHead){
            int length = 0;
            ListNode listNode = pHead;
            while (listNode != null){
                length++;
                listNode = listNode.next;
            }
            return length;
        }

    }


}
