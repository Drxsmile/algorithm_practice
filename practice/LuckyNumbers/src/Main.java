import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String[] luckyNumbers(String num, int target) {
        ArrayList<String> res = new ArrayList<>();
        if(!"".equals(num))
            recursion(res, "", num,0, target, 0, 0);
            String[] ss = new String[res.size()];
        return res.toArray(ss);
    }
    static void recursion(ArrayList<String> res, String temp, String num, int index, int target, long cur, long last){
        if(index == num.length()){
            if(cur == target)
                res.add(temp);
            return;
        }

        for(int i = index; i < num.length(); i++){
            String s = num.substring(index, i+1);
            long val = Long.valueOf(s);
            if(index == 0){
                recursion(res,temp + s, num, i+1, target, val, val);
            }else{
                recursion(res, temp + "+" + s, num, i + 1, target, cur + val, val);
                recursion(res, temp + "-" + s, num, i + 1, target, cur - val, -val);
                recursion(res, temp + "*" + s, num, i + 1, target, cur - last + last * val, last * val);
                if(val !=0 && cur % val == 0)
                    recursion(res, temp + "/" + s, num, i + 1, target, cur - last + last / val, last / val);
            }
            if(num.charAt(index) == '0') break;
        }
    }

    static void recursion2(ArrayList<String> res, String path, String num, int index, int target, long cur, long pre, String operator){
        if(index == num.length()){
            if(cur == target){
                res.add(path);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            
        }
    }

        /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;

        String _num;
        try {
            _num = in.nextLine();
        } catch (Exception e) {
            _num = null;
        }

        int _target;
        _target = Integer.parseInt(in.nextLine().trim());

        res = luckyNumbers(_num, _target);
        Arrays.sort(res);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
