package com.snx;

/*
* Given a string and a dictionary, calculate how many characters need to be removed at least, so that the document is composed by the words in the dictionary.
* output: minimum number of characters you need to remove. If no available word can be formed, return the length of the string since all the characters have to be removed.
* */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int removeCharacters(String str, String[] dict) {
        Arrays.sort(dict, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });
        int lcs = 0;
        for(int i = 0; i < dict.length; i++){
            str = str.replaceAll(dict[i], "");
            int[][] dp = new int[str.length() + 1][dict[i].length() + 1];
            for(int p = 1; p <= str.length(); p++){
                for(int q = 1; q <= dict[i].length(); q++){
                    if(str.charAt(p - 1) == dict[i].charAt(q - 1)){
                        dp[p][q] = dp[p - 1][q - 1] + 1;
                    }else{
                        dp[p][q] = Math.max(dp[p - 1][q], dp[p][q - 1]);
                    }
                }

            }
            if(dp[str.length()][dict[i].length()] == dict[i].length()){
                lcs += dict[i].length();

                System.out.println(lcs);
            }
        }


        return str.length() - lcs;
    }
    /******************************结束写代码******************************/

    /****************************answer******************************/
    static int calcMaxMatch(String str, String[] dict){
        int maxMatchLen = 0;
        for(String word:dict){
            int m = 0,i =0, j =0;
            // 遍历str，如何包含word计数给m，不包含m还是0
            do{
                if (str.charAt(j) == word.charAt(i)) {
                    i++;
                    if (i == word.length()) { m = word.length();break;}
                }
                j++;
            }while(j < str.length());
            if(m > maxMatchLen){
                maxMatchLen =m;
            }
        }
        // 返回的是0（所有词都不包含），或者包含的词里最长的长度
        return maxMatchLen;
    }
    static int removeCharactersAns(String str, String[] dict)
    {
        int len = str.length();
        int[] dp= new int[len + 1];
        dp[0] = 0;
        for(int i = 1; i <= len ; i++) dp[i] = Integer.MAX_VALUE;
        for(int i =1 ; i <= len ; i++){
            for(int j = 0 ; j < i ; j++){
                String substr = str.substring(j,i);
                int maxMatch = calcMaxMatch(substr, dict);
                if (dp[j]!=Integer.MAX_VALUE && dp[i] > dp[j] + i - j  - maxMatch) {
                    dp[i] = dp[j] + i - j  - maxMatch;
                }
            }
        }
        return dp[len];
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
        int res;

        String _str = "apiplehaellohaecontinent";
        String[] _dict = {"hello", "he", "apple", "app", "continent"};
//        try {
//            _str = in.nextLine();
//        } catch (Exception e) {
//            _str = null;
//        }
//
//        int _dict_size = 0;
//        _dict_size = Integer.parseInt(in.nextLine().trim());
//        String[] _dict = new String[_dict_size];
//        String _dict_item;
//        for(int _dict_i = 0; _dict_i < _dict_size; _dict_i++) {
//            try {
//                _dict_item = in.nextLine();
//            } catch (Exception e) {
//                _dict_item = null;
//            }
//            _dict[_dict_i] = _dict_item;
//        }

        res = removeCharacters(_str, _dict);
        int res2 = removeCharactersAns(_str, _dict);
        System.out.println(String.valueOf(res));
        System.out.println(res2);

    }
}
