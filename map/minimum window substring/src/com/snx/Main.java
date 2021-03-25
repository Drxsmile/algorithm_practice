package com.snx;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String r = minWindow(s, t);
        System.out.println(r);
    }
    public static String minWindow(String s, String t) {
        int[] need = new int[256];
        int size = 0;
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(need[c] == 0) size++;
            need[c]++;
        }
        int[] win = new int[256];
        int left = 0, right = 0;
        int valid = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need[c] != 0){
                win[c]++;
                if(win[c] == need[c]) valid++;
            }
            int start = left;
            System.out.println("window: "+ left + " " + right);
            while(valid == size){
                char d = s.charAt(left);
                left++;
                if(need[d] != 0){
                    if(win[d] == need[d]) valid--;
                    win[d]--;
                }
            }
            if(start != left && right - left + 1 < len){
                len = right - left + 1;
                res = s.substring(left - 1, right);
            }
        }
        return res;
    }
    public static String minWindow1(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> win = new HashMap<>();
        int valid = 0;
        int left = 0;
        int right = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                win.put(c, 1 + win.getOrDefault(c, 0));
                if(win.get(c).equals(need.get(c)))
                    valid ++;
            }
            int start = left;
            System.out.println("window: "+ left + " " + right);
            while(valid == need.size()){
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(win.get(d).equals(need.get(d))) valid--;
                    win.put(d, win.getOrDefault(d, 0) - 1);
                }

            }
            if(start != left){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    res = s.substring(left - 1, right);
                }
            }

        }
        return res;
    }
}
