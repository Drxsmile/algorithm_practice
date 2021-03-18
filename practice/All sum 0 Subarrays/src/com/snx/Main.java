package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
example
input:[6,3,-1,-3,4,-2,2,4,6,-12,-7]
output:[[0,10],[2,4],[2,6],[5,6],[6,9]]
 */
public class Main {
    // 答案
    static class MyComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        }
    }

    static List<List<Integer>> findSubArrays(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        int sum = 0;
        List<Integer> index = new ArrayList<>();
        index.add(-1);
        map.put(0, index);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                index = map.get(sum);
                for (int j = 0; j < index.size(); j++) {
                    List<Integer> result = new ArrayList<>();
                    result.add(index.get(j) + 1);
                    result.add(i);
                    results.add(result);
                }
                index.add(i);
            }
            else {
                index = new ArrayList<>();
                index.add(i);
                map.put(sum, index);
            }
        }
        Comparator comparator = new MyComparator();
        Collections.sort(results, comparator);
        return results;
    }
    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static List<List<Integer>> findSubArrays2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        List<Integer> list = new LinkedList<>();
        list.add(-1);
        map.put(0, list);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            List<Integer> temp;
            if(!map.containsKey(sum)){
                temp = new LinkedList<>();
            }else{
                temp = map.get(sum);
            }
            temp.add(i);
            map.put(sum, temp);
        }
        sum = 0;
        if(map.get(0).size() > 1){
            List<Integer> t = new LinkedList<>();
            t.add(0);
            for(int i = 1; i < map.get(0).size(); i++){
                t.add(map.get(0).get(i));
                res.add(new LinkedList(t));
                t.remove(t.size() - 1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.get(sum).size() > 1){
                List<Integer> t = new LinkedList<>();
                t.add(i + 1);
                for(int j = 0; j < map.get(sum).size(); j++){
                    if(map.get(sum).get(j) <= i) continue;
                    t.add(map.get(sum).get(j));
                    res.add(new LinkedList(t));
                    t.remove(t.size() - 1);
                }
            }
        }
//        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
//            List<Integer> temp = entry.getValue();
//            if(temp.size() == 2){
//                temp.set(0, temp.get(0) + 1);
//                res.add(temp);
//            }
//            if(temp.size() > 2){
//                for(int i = 0; i < temp.size() - 1; i++){
//                    List<Integer> t = new LinkedList<>();
//                    t.add(temp.get(i) + 1);
//                    for(int j = i + 1; j < temp.size(); j++){
//                        t.add(temp.get(j));
//                        res.add(new LinkedList(t));
//                        t.remove(t.size() - 1);
//                    }
//                }
//            }
//        }
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

        List<List<Integer>> res = findSubArrays(nums);
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (List<Integer> list : res) {
            StringJoiner sj = new StringJoiner(",", "[", "]");
            sj.add(list.get(0).toString()).add(list.get(1).toString());
            stringJoiner.add(sj.toString());
        }
        System.out.println(stringJoiner.toString());
    }
}
