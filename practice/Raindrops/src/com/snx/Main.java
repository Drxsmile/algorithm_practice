package com.snx;

/*
When it rains, each raindrop could cover a certain area. If we have an array of each raindrop, could you tell k that the first k raindrops can final make this sidewalk all wet?

The input will be a 2-dimenstion array. Sidewalk will be [0,1] always N lines with 2 numbers in each line, meaning the range that a raindrop could cover. Return k if the first k raindrop could already cover the sidewalk. Return -1 if all the raindrops can still not cover the sidewalk.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int rainDrops(double[][] rain) {
        if(rain.length == 0) return -1;
        if(doubleCompare(rain[0][0], 0.0) <= 0 && doubleCompare(rain[0][1], 1.0) >= 0) return 1;
        // set存储未合并的区间
        HashSet<double[]> set = new HashSet<>();
        set.add(rain[0]);
        for(int i = 1; i < rain.length; i++){
            // set2存储合并到rain[i]里的区间
            HashSet<double[]> set2 = new HashSet<>();
            for(double[] cur : set){
                if(overlap(cur, rain[i])){
                    rain[i][0] = Math.min(rain[i][0], cur[0]);
                    rain[i][1] = Math.max(rain[i][1], cur[1]);
                    if(doubleCompare(rain[i][0], 0.0) <= 0 && doubleCompare(rain[i][1], 1.0) >= 0) return i + 1;
                    set2.add(cur);
                }
            }
            set.removeAll(set2);
            set.add(rain[i]);

        }
        return -1;
    }
    static boolean overlap(double[] a, double[] b){
        if(doubleCompare(a[0], b[0]) > 0) return overlap(b, a);
        if(doubleCompare(a[1], b[0]) < 0) return false;
        return true;
    }
    static int doubleCompare(double a, double b){
        BigDecimal ba = new BigDecimal(a);
        BigDecimal bb = new BigDecimal(b);
        return ba.compareTo(bb);
    }
    /******************************结束写代码******************************/

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************答案在这里******************************/
    static int rainDropsAns(double[][] rain) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(rain[0][0], rain[0][1]));
        for (int i = 1; i < rain.length; i ++) {
            if (intervals.size() == 1 && intervals.get(0).start < 1e-5 && intervals.get(0).end >= 1 - 1e-5) {
                return i;
            }
            insert(intervals, new Interval(rain[i][0], rain[i][1]));
        }
        if (intervals.size() == 1 && intervals.get(0).start < 1e-5 && intervals.get(0).end >= 1 - 1e-5) {
            return rain.length;
        } else {
            return -1;
        }
    }

    static void insert(List<Interval> intervals, Interval newInterval) {
        ListIterator<Interval> it = intervals.listIterator();
        while(it.hasNext()) {
            Interval tmpInterval = it.next();
            if(newInterval.end < tmpInterval.start) {
                it.previous();
                it.add(newInterval);
                return;
            } else {
                if(tmpInterval.end < newInterval.start) {
                    continue;
                } else {
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);
                    it.remove();
                }
            }
        }
        intervals.add(newInterval);
    }
    static class Interval{
        double start;
        double end;
        Interval(double s, double e) {
            start = s;
            end = e;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
        int res;
//
//        int _rain_rows = 0;
//        int _rain_cols = 0;
//        _rain_rows = Integer.parseInt(in.nextLine().trim());
//        _rain_cols = Integer.parseInt(in.nextLine().trim());
//
//        double[][] _rain = new double[_rain_rows][_rain_cols];
//        for(int _rain_i=0; _rain_i<_rain_rows; _rain_i++) {
//            for(int _rain_j=0; _rain_j<_rain_cols; _rain_j++) {
//                _rain[_rain_i][_rain_j] = in.nextDouble();
//
//            }
//        }
//
//        if(in.hasNextLine()) {
//            in.nextLine();
//        }
        double[][] _rain = {{0, 1}, {0.3, 0.6}, {0.5, 0.8}, {0.67, 1}, {0, 0.4}, {0.5, 0.75} };
        res = rainDrops(_rain);
        int res2 = rainDropsAns(_rain);
        System.out.println(String.valueOf(res));
        System.out.println(res2);

    }
}
