package practice.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by wch on 2018/3/29.
 */
public class Test34 {

    static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int expectedSum){
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        if(root == null){
           return pathList;
        }
        findPathCore(root,expectedSum,path,pathList);
        return pathList;


    }
    public static void findPathCore(TreeNode root, int expectedSum, ArrayList<Integer> path,ArrayList<ArrayList<Integer>> pathList){
        boolean isLeaf = root.left == null && root.right == null;
        int reminder = expectedSum - root.val;
        path.add(root.val);
        if(isLeaf && reminder == 0){
            ArrayList<Integer> pathCopy = new ArrayList<>(path);
            pathList.add(pathCopy);
        }
        if(root.left!=null){
            findPathCore(root.left,reminder,path,pathList);
        }
        if(root.right != null){
            findPathCore(root.right,reminder,path,pathList);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode L1 = new TreeNode(5);
        TreeNode R1 = new TreeNode(12);
        root.left = L1;
        root.right = R1;
        TreeNode L2 = new TreeNode(4);
        TreeNode R2 = new TreeNode(7);
        L1.left = L2;
        L1.right =R2;

        ArrayList<ArrayList<Integer>> pathList = findPath(root,22);
        for (ArrayList<Integer> path: pathList) {
            for (Integer i : path) {
                System.out.print(i+ "  ");
            }
            System.out.println();
        }
    }
}
