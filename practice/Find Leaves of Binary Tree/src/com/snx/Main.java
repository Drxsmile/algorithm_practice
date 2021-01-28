package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

//    static List<List<Integer>> res = new ArrayList<>();
//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    public static List<List<Integer>> findLeaves(TreeNode root) {
//        if(root != null){
//            while(root.left != null || root.right != null){
//                res.add(new ArrayList());
//                dfs(root);
//            }
//            res.add(new ArrayList(Arrays.asList(root.val)));
//        }
//        return res;
//    }
//    public static void dfs(TreeNode root){
//        if(root == null) return;
//        if(root.left != null){
//            if(root.left.left == null && root.left.right == null){
//                res.get(res.size() - 1).add(root.left.val);
//                root.left = null;
//            }
//            dfs(root.left);
//        }
//        if(root.right != null){
//            if(root.right.left == null && root.right.right == null){
//                res.get(res.size() - 1).add(root.right.val);
//                root.right = null;
//            }
//            dfs(root.right);
//        }
//
//    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private static int height(TreeNode node, List<List<Integer>> res){
        if(null==node)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if(res.size()<level+1)  res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
    /******************************结束写代码******************************/
    static public TreeNode constructTree(String tree) {
        String[] nodes = tree.split(",");
        TreeNode root = null;
        if (nodes[0].equals("")) {
            return root;
        }
        root = new TreeNode(Integer.parseInt(nodes[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (index < nodes.length) {
            TreeNode tmp = queue.poll();
            if (!nodes[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                tmp.left = leftNode;
                queue.offer(leftNode);
            }
            index++;
            if (index >= nodes.length)
                break;
            if (!nodes[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                tmp.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }
        return root;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String tree = in.nextLine().trim();
        TreeNode root = constructTree(tree.substring(1, tree.length() - 1));
        List<List<Integer>> res = findLeaves(root);
        List<String> printRes = new ArrayList<String>();
        for (int i = 0; i < res.size(); i++) {
            Collections.sort(res.get(i));
            List<String> tmp = new ArrayList<String>();
            for (int j = 0; j < res.get(i).size(); j++)
                tmp.add(res.get(i).get(j).toString());
            printRes.add("[" + String.join(",", tmp) + "]");
        }
        System.out.println("[" + String.join(",", printRes) + "]");
    }
}
