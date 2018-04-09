package practice.jianzhioffer;


/**
 * Created by wch on 2018/3/27.
 */

/**
 * 找到链表中环的入口
 *
 * 要点：使用两个指针，一个快指针（一次走两步），一个慢指针（一次走一步），
 * 两个指针相遇则说明有环，且快指针比慢指针多走的步数为环的长度
 */
public class Test23 {
    static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode entryNodeOfLoop(ListNode head){
        if (head == null ){
            return null;
        }
        int lenth = loopLength(head);
        if(lenth == 0){
            return null;
        }else{
            ListNode ahead = head,behind = head;
            for (int i = 0; i < lenth; i++) {
                ahead = ahead.next;
            }
            while (ahead!=behind){
                ahead = ahead.next;
                behind = behind.next;
            }
            return ahead;
        }
    }

    /**
     * 得到环中节点个数，如果没有环则返回0
     * @param head
     * @return
     */
    public static int loopLength(ListNode head){
        if(head == null||head.next == null){
            return 0;
        }
        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;
        int stepNum = 1;
        while (fastNode != null&&fastNode!=slowNode){
            if(fastNode.next!=null) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
                stepNum++;
            }else{
                return 0;
            }
        }
        if(fastNode == null){
            return 0;
        }
        return stepNum;
    }


}
