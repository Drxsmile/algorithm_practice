package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int[] sortFrequency(int[] nums) {
        if(nums.length == 0) return nums;
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue maxHeap = new PriorityQueue<>(map.size(), new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(map.get(b) == map.get(a)){
                    for (int num : map.keySet()) {
                        if(num != a && num != b) continue;
                        if(num == a) return -1;
                        if(num == b) return 1;
                    }
                }
                return map.get(b) - map.get(a);
            }
        });
        for(int i : map.keySet()){
            System.out.println(i);
            maxHeap.offer(i);
        }
        for(int i = 0; i < nums.length; i++){
            res[i] = (int)maxHeap.poll();
            int freq = map.get(res[i]);
            while(freq != 1){
                res[i + 1] = res[i++];
                freq--;
            }
        }
        return res;

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

        int[] res = sortFrequency(nums);
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int num : res)
            sj.add(String.valueOf(num));
        System.out.println(sj.toString());
    }
}
