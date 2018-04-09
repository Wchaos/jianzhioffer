package practice.jianzhioffer;

/**
 * Created by wch on 2018/3/28.
 */

/**
 * 判断树B是不是树A的子树
 *
 * 两个递归
 */
public class Test26 {

    static class BinaryTreeNode {
        double value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 第一步：从根节点开始先找到值相等的节点
     * 第二步：从相等的根节点开始递归判断下面的结构是否相同
     * 第三步：如果判断之后不相同，继续向左子树和右子树递归寻找值相等的节点
     * @param rootA
     * @param rootB
     * @return
     */
    public static boolean hasSubtree(BinaryTreeNode rootA, BinaryTreeNode rootB) {
        boolean result = false;
        if(rootA != null&&rootB!= null){
            if(equal(rootA.value,rootB.value)){
                result = doseTreeAHaveTreeB(rootA,rootB);
            }
            if(!result){
                result = hasSubtree(rootA.left,rootB)||hasSubtree(rootA.right,rootB);
            }
        }
        return result;
    }

    /**
     * 沿着值相等的节点向下递归判断下面的结构是否相同
     * @param rootA
     * @param rootB
     * @return
     */
    private static boolean doseTreeAHaveTreeB(BinaryTreeNode rootA,BinaryTreeNode rootB){
        if(rootB == null){
            return true;
        }
        if(rootA == null){
            return false;
        }
        if (equal(rootA.value, rootB.value)) {
            return doseTreeAHaveTreeB(rootA.left,rootB.left)&&doseTreeAHaveTreeB(rootA.right,rootB.right);
        }else{
            return false;
        }

    }


    private static boolean equal(double num1, double num2) {
        return Math.abs(num1 - num2) < 0.0000001;
    }


    public static void main(String[] args) {
        BinaryTreeNode rootA = new BinaryTreeNode(8);
        BinaryTreeNode a1 = new BinaryTreeNode(8);
        rootA.left = a1;
        BinaryTreeNode a2 = new BinaryTreeNode(7);
        rootA.right = a2;
        BinaryTreeNode a3 = new BinaryTreeNode(9);
        a1.left = a3;
        BinaryTreeNode a4 = new BinaryTreeNode(2);
        a1.right = a4;
        BinaryTreeNode a5 = new BinaryTreeNode(4);
        a4.left = a5;
        BinaryTreeNode a6 = new BinaryTreeNode(7);
        a4.right = a6;

        BinaryTreeNode rootB = new BinaryTreeNode(8);
        BinaryTreeNode b1 = new BinaryTreeNode(9);
        rootB.left = b1;
        BinaryTreeNode b2 = new BinaryTreeNode(2);
        rootB.right = b2;
        boolean res = hasSubtree(rootA,rootB);
        System.out.println(res);
    }


}
