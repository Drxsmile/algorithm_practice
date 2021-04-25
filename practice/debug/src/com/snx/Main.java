package com.snx;

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
        for(int i = 0; i < dict.length; i++){
            System.out.println(1);
            str = str.replaceAll(dict[i], "");
        }
        System.out.println(str);
        return str.length();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        int _dict_size = 0;
        _dict_size = Integer.parseInt(in.nextLine().trim());
        String[] _dict = new String[_dict_size];
        String _dict_item;
        for(int _dict_i = 0; _dict_i < _dict_size; _dict_i++) {
            try {
                _dict_item = in.nextLine();
            } catch (Exception e) {
                _dict_item = null;
            }
            _dict[_dict_i] = _dict_item;
        }

        res = removeCharacters(_str, _dict);
        System.out.println(String.valueOf(res));

    }
}
