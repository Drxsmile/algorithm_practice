package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static List<String> res = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static int minLen = Integer.MAX_VALUE;
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static List<String> findAllConcatenated(String[] words) {

        if(words.length != 0){
            for(String word : words){
                int len = word.length();
                map.put(word, len);
                if(minLen > len) minLen = len;
            }
            for(String word : words){
                if(word.length() == minLen) continue;
                if(dfs(word, true)) res.add(word);
            }
        }
        return res;
    }
    static boolean dfs(String word, boolean origin){
        if(map.containsKey(word) && !origin) return true;
        boolean res = false;
        for(int i = minLen; i < word.length(); i++){
            String sl = word.substring(0, i);
            if(!map.containsKey(sl)) continue;
            String sr = word.substring(i, word.length());
            if(dfs(sr, false)) res = true;
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> res;

        int _words_size = 0;
        _words_size = Integer.parseInt(in.nextLine().trim());
        String[] _words = new String[_words_size];
        String _words_item;
        for(int _words_i = 0; _words_i < _words_size; _words_i++) {
            try {
                _words_item = in.nextLine();
            } catch (Exception e) {
                _words_item = null;
            }
            _words[_words_i] = _words_item;
        }

        res = findAllConcatenated(_words);
        for(int res_i=0; res_i < res.size(); res_i++) {
            System.out.println(String.valueOf(res.get(res_i)));
        }

    }
}
