package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
example
input: [90,15,10,7,12,2,7,3]
output: true
 */
public class Main {
    // answer
    static boolean isMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (nums[2 * i + 1] > nums[i]) return false;
            if ((2 * i + 2 < n) && nums[2 * i + 2] > nums[i]) return false;
        }
        return true;
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static boolean isMaxHeap2(int[] nums) {
        if(nums.length == 0) return false;

        //Queue<Integer> q = new LinkedList<>(nums);
        TreeNode root = new TreeNode(nums[0]);
        int i = 1;
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.offer(root);
        while(i != nums.length && !q2.isEmpty()){
            TreeNode cur = q2.poll();
            cur.left = new TreeNode(nums[i++]);
            if(cur.left.val > cur.val) return false;
            if(i == nums.length) break;
            cur.right = new TreeNode(nums[i++]);
            if(cur.right.val > cur.val) return false;
            q2.offer(cur.left);
            q2.offer(cur.right);
        }
//        if(height(root.left) != height(root.right)) return false;
        return true;
    }
//    static int height(TreeNode root){
//        if(root == null) return 0;
//        return Math.min(height(root.left), height(root.right)) + 1;
//    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    static boolean isMaxHeap3(int[] nums){
        if(nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if(2 * i + 1 < nums.length){
                if(nums[2 * i + 1] > nums[i])
                    return false;
            }else break;
            if(2 * i + 2 < nums.length){
                if(nums[2 * i + 2] > nums[i])
                    return false;
            }else break;
        }
        return true;
    }
    /******************************结束写代码******************************/

    public static List<Integer> extractNumList(String arr) {
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(arr);
        List<Integer> res = new ArrayList<>();
        while (matcher.find()) {
            res.add(Integer.parseInt(matcher.group()));
        }
        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String arr = in.nextLine().trim();
        List<Integer> array = extractNumList(arr);
        int[] nums = array.stream().mapToInt(Integer::valueOf).toArray();

        boolean res =  isMaxHeap(nums) == isMaxHeap2(nums);
        System.out.println(res ? "true" : "false");
    }
}
