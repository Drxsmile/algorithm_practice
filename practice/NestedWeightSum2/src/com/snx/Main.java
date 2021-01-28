package com.snx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class NestedInteger {
    public List<NestedInteger> list;
    public Integer num;
    public boolean isinteger;
    public NestedInteger() {
        list = null;
        isinteger = true;
    }
    public NestedInteger(int value) {
        num = value;
        isinteger = true;
    }
    // return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isinteger;
    }
    // return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if (isinteger)
            return num;
        else
            return null;
    }
    public void setIntger(int value) {
        if (isinteger)
            num = value;
    }
    public void add(NestedInteger ni) {
        isinteger = false;
        if (list == null)
            list = new ArrayList<NestedInteger>();
        list.add(ni);
    }
    // return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        if (isinteger)
            return null;
        else
            return this.list;
    }
}

public class Main {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nestedList, 0, path);
        int dep = path.size();
        int val = 0;
        for(int i = 0; i < path.size(); i++){
            val += path.get(i).intValue() * dep--;
        }
        return val;
    }
    static void dfs(List<NestedInteger> list, int index, ArrayList<Integer> path){
        if(list == null) return;
        for(int i = 0; i < list.size(); i++){
            NestedInteger nest = list.get(i);
//            System.out.println(i);
//            System.out.println(nest.getInteger());
            if(nest.isInteger() && nest.getInteger() != null){
                int val = nest.getInteger();
                while(index > path.size() - 1) {
                    path.add(0);
                }
                path.set(index, val + path.get(index).intValue());
            }else{
                dfs(nest.getList(), index + 1, path);
            }
        }
    }
    /******************************结束写代码******************************/
    static List<NestedInteger> loadData(String text) {
        Stack<NestedInteger> stk = new Stack<NestedInteger>();
        Stack<Integer> nums = new Stack<Integer>();
        nums.push(0);
        int index = 0;
        while (index < text.length()) {
            if (text.charAt(index) == '[') {
                nums.push(0);
            }
            else if (text.charAt(index) == ']') {
                NestedInteger ni = new NestedInteger();
                Integer n = nums.pop();
                Stack<NestedInteger> tmp = new Stack<NestedInteger>();
                while (n-- > 0) {
                    tmp.push(stk.pop());
                }
                while (!tmp.empty()) {
                    ni.add(tmp.pop());
                }
                stk.push(ni);
                int number = nums.pop();
                nums.push(++number);
            }
            else if (text.charAt(index) == '-' || (text.charAt(index) >= '0' && text.charAt(index) <= '9')) {
                int beginIndex = index++;
                while (text.charAt(index) >= '0' && text.charAt(index) <= '9') {
                    index++;
                }
                NestedInteger tmp = new NestedInteger(Integer.parseInt(text.substring(beginIndex, index)));
                stk.push(tmp);
                int number = nums.pop();
                nums.push(++number);
                index--;
            }
            index++;
        }
        return stk.pop().getList();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String text = in.nextLine().trim();
        List<NestedInteger> nestedList = loadData(text);

        int res = depthSumInverse(nestedList);
        System.out.println(String.valueOf(res));
    }
}
