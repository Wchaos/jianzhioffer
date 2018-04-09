package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/30.
 */
public class Test35 {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            RandomListNode node = this;
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            while (node!=null){
                sb.append(node.label);
                if(node.random != null){
                    sb.append("(");
                    sb.append(node.random.label);
                    sb.append(")");
                }
                sb.append(", ");
                node = node.next;
            }
            sb.deleteCharAt(sb.lastIndexOf(" "));
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("]");
            return sb.toString();
        }
    }

    public static RandomListNode clone(RandomListNode head){
        cloneNodes(head);
        connectRandomNodes(head);
        RandomListNode cloneHead = divideNodes(head);
        return cloneHead;

    }

    private static void cloneNodes(RandomListNode head){
        RandomListNode listNode = head;
        while (listNode != null){
            RandomListNode cloneNode = new RandomListNode(listNode.label);//复制当前节点
            //将复制节点插入到当前节点后面
            cloneNode.next = listNode.next;
            listNode.next = cloneNode;
            //移动到下一个需要复制的节点
            listNode = cloneNode.next;
        }
    }

    private static void connectRandomNodes(RandomListNode head){
        RandomListNode listNode = head;
        while (listNode != null){
            RandomListNode randomNode = listNode.random;
            if(randomNode != null){
                listNode.next.random = randomNode.next;
            }
            listNode = listNode.next.next;
        }
    }

    private static  RandomListNode divideNodes(RandomListNode head){
        if(head == null){
            return null;
        }
        RandomListNode listNode = head;
        RandomListNode cloneHead = head.next;
        RandomListNode cloneNode = cloneHead;
        while(cloneNode.next!= null){
            //拆分原节点和复制节点
            listNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next.next;
            //移动到下一个需拆分的节点
            listNode = listNode.next;
            cloneNode = cloneNode.next;
        }
        listNode.next = null; //最后一个节点，指向null
        return cloneHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode a1 = new RandomListNode(2);
        RandomListNode a2 = new RandomListNode(3);
        RandomListNode a3 = new RandomListNode(4);
        RandomListNode a4 = new RandomListNode(5);

        head.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        head.random = a2;
        a1.random = a4;
        a3.random = a1;
        System.out.println("复制前的链表："+head.toString());
        RandomListNode cloneHead = clone(head);
        System.out.println("复制后的原链表："+head.toString());
        System.out.println("复制的链表："+cloneHead.toString());

    }



}
