package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    private static int sides;
    private static boolean res = false;
    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static boolean formPolygon(int[] sticks, int sides) {
        int sum = 0;
        for (int i = 0; i < sticks.length; i++) {
            sum = sum + sticks[i];
        }
        if(sum / sides * sides != sum) return false;
        int len = sum / sides;
        Arrays.sort(sticks);
        if(sticks[sticks.length - 1] > len) return false;
        int[] side = new int[sides];
        exist(len, sticks, side, 0);
        return res;
    }
    static void exist(int len, int[] sticks, int[] side, int index){
        // base case
        if(index == sticks.length) {
            for (int i = 0; i < sides; i++) {
                if(side[i] != len) return;
            }
            res = true;
            return;
        }
        // recursion rule
        for (int i = 0; i < sides; i++) {
            if(side[i] > len) continue;
            int cur = sticks[index];
            side[i] += cur;
            exist(len, sticks, side, index + 1);
            side[i] -= cur;

        }
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
        int[] sticks = array.stream().mapToInt(Integer::valueOf).toArray();
        int sides = Integer.parseInt(in.nextLine().trim());

        boolean res = formPolygon(sticks, sides);
        System.out.println(res ? "true" : "false");
    }
}