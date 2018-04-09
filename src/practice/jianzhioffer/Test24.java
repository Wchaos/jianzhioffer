package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/27.
 */
public class Test24 {
    static class ListNode{
        int value;
        ListNode next = null;
        ListNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append('[');
            ListNode listNode = this;
            while(listNode!= null){
                sb.append(listNode.value);
                sb.append(", ");
                listNode = listNode.next;

            }
            sb.delete(sb.length()-2,sb.length());
            sb.append(']');
            return sb.toString();
        }
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode reverseHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }

    /**
     * 循环解法（推荐）
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){

        ListNode reverseHead = null;
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode!=null){
            ListNode nextNode = curNode.next;  //因为要反转当前节点指针，所以每次需要记录下一个节点，防止链表断裂
            if(nextNode == null){
                reverseHead = curNode;   //将最后一个节点记录为新的头结点
            }

            curNode.next = preNode;    //反转当前节点指针，指向前一个节点

            preNode = curNode;  //记录即将成为前一个节点的节点
            curNode = nextNode;  // 准备处理下一个节点
        }
        return reverseHead;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        ListNode head = new ListNode(nums[0]);
        ListNode listNode = head;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        Test24 test24 =  new Test24();
        ListNode reverseHead = test24.reverseList1(head); //反转
        System.out.println(reverseHead.toString());

        System.out.println(test24.reverseList2(reverseHead).toString());//反转回来

    }

}
