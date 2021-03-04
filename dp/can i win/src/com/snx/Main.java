package com.snx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
    public boolean canIWin(int max, int des) {
        if(max * (max + 1) < 2 * des) return false;
        if(des == 0 || max >= des) return true;
        int[] used = new int[max];
        for(int i = 1; i <= max; i++){
            used[i - 1] = 1;
            if(dfs(used, max, des - i, false)){
                return true;
            }
            used[i - 1] = 0;
        }
        return false;
    }
    public boolean dfs(int[] used, int num, int des, boolean player){
        // base case
        if(des <= 0) return !player;
        // recursion rule
        for(int i = 1; i <= num; i++){
            if(used[i - 1] == 1) {

                continue;}
            used[i - 1] = 1;
            System.out.println(player + ":" + i);
            if(!dfs(used, num, des - i, !player)){
                System.out.println(des + ":" + false);
                used[i - 1] = 0;
                return false;
            }
            used[i - 1] = 0;
        }
        System.out.println(des + ":" + true);
        return true;
    }
}

public class Main {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int maxChoosableInteger = Integer.parseInt(line);
//            line = in.readLine();
//            int desiredTotal = Integer.parseInt(line);
//
//            boolean ret = new Solution().canIWin(maxChoosableInteger, desiredTotal);
//
//            String out = booleanToString(ret);
//
//            System.out.print(out);
//        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "cookie");
        map.put("age", "18");
        map.put("sex", "女");
        String name = map.getOrDefault("name", "random");
        System.out.println(name);// cookie，map中存在name,获得name对应的value
        int score = Integer.parseInt(map.getOrDefault("score", "80"));
        System.out.println(score);// 80，map中不存在score,使用默认值80
        System.out.println(map.containsKey("score"));

    }
}