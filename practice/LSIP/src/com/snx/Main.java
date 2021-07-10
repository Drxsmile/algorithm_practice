package com.snx;

import java.util.Scanner;
public class Main {
    public static boolean flag = true;
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
        String s = "(add (div -7 (div -7 3)) (div (div -7 3) 3))";
        int res = comp(s);
        if(flag){
            System.out.println(res);
        }else{
            System.out.println("error");
        }
    }
    public static int comp(String str){
        String oper = str.substring(1, 4);
        int para1;
        int i = 5;
        System.out.println(str);
        if(str.charAt(5) != '('){
            while(str.charAt(i) != ' '){
                i++;
            }
            String s1 = str.substring(5, i);
            para1 = Integer.parseInt(s1);
        }else{
            int cnt = 1;
            while(cnt != 0){
                i++;
                if(str.charAt(i) == '(') cnt++;
                else if(str.charAt(i) == ')') cnt--;
            }

            String s1 = str.substring(5, ++i);
            para1 = comp(s1);
            System.out.println("1:" + para1);
        }
        int para2;
        i++;
        String s2 = str.substring(i, str.length() - 1);
        if(str.charAt(i) != '('){
            para2 = Integer.parseInt(s2);
        }else{
            para2 = comp(s2);
            System.out.println("2:" + para2);
        }
        if(oper.equals("add")){
            return para2 + para1;
        }else if(oper.equals("sub")){
            return para1 - para2;
        }else if(oper.equals("mul")){
            return para1 * para2;
        }else{
            if(para2 == 0){
                flag = false;
                return 1;
            }else{
                int r = para1 / para2;
                if(r < 0 && para1 % para2 != 0) r--;
                return r;
            }
        }
    }
}
