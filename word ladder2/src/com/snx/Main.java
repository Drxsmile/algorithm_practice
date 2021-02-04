package com.snx;

import java.util.*;

public class Main {
    static List<List<String>> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();
    static Map<String, Set<String>> map = new HashMap<>();
    static int size = 0;
    public static void main(String[] args) {
        String[] words = {"rex", "ted", "tex", "tad", "tax"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return res;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while(!q.isEmpty()){
            Queue<String> q2 = new LinkedList<>();
            Set<String> temp = new HashSet<>();
            step++;
            while(!q.isEmpty()){
                String cur = q.poll();
                if(bfs(cur, q2, endWord, wordSet, temp)){
            System.out.println(1);
                    if(size == 0) size = step;
                }
            }
            System.out.println(temp);

            if(temp.contains(endWord)){
                dfs(beginWord, endWord, 0);
                return res;
            }
            wordSet.removeAll(temp);
            q = q2;
        }
        return res;
    }
    public static boolean bfs(String cur, Queue<String> q2, String endWord, Set<String> wordSet,Set<String> temp){
        System.out.println(cur);
        map.put(cur, new HashSet<>());
        System.out.println(map);
        char[] curArray = cur.toCharArray();
        boolean flag = false;
        for(int i = 0; i < curArray.length; i++){
            char origin = curArray[i];
        System.out.println(origin);
        System.out.println(map);
            for(char c = 'a'; c <= 'z'; c++){
                if(c == origin) continue;
                curArray[i] = c;
                String word = new String(curArray);
                if(wordSet.contains(word)){
                    temp.add(word);
                    map.get(cur).add(word);
                    if(word.equals(endWord)){
                        flag = true;
                    }else{
                        q2.offer(word);
                    }
                }

            }
            curArray[i] = origin;
        }
        return flag;
    }
    public static void dfs(String beginWord, String endWord, int index){
        if(index == size - 1){
            if(beginWord.equals(endWord)){
                path.add(beginWord);
                res.add(new ArrayList(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(beginWord);
        Set<String> set = map.get(beginWord);
        for(String word : set){
            dfs(word, endWord, index+1);
        }
        path.remove(path.size() - 1);
    }
}

//class Solution {
//    List<List<String>> res = new ArrayList<>();
//    List<String> path = new ArrayList<>();
//    Map<String, Set<String>> map = new HashMap<>();
//    int size = 0;
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordSet = new HashSet<>(wordList);
//        if(!wordSet.contains(endWord)) return res;
//        Queue<String> q = new LinkedList<>();
//        q.offer(beginWord);
//        int step = 1;
//        while(!q.isEmpty()){
//            Queue<String> q2 = new LinkedList<>();
//            Set<String> temp = new HashSet<>();
//            step++;
//            while(!q.isEmpty()){
//                String cur = q.poll();
//                if(bfs(cur, q2, endWord, wordSet, temp)){
//                    if(size == 0) size = step;
//                }
//            }
//            if(temp.contains(endWord)){
//                dfs(beginWord, endWord, 0);
//                return res;
//            }
//            wordSet.removeAll(temp);
//            q = q2;
//        }
//        return res;
//    }
//    public boolean bfs(String cur, Queue<String> q2, String endWord, Set<String> wordSet,Set<String> temp){
//        map.put(cur, new HashSet<>());
//        char[] curArray = cur.toCharArray();
//        boolean flag = false;
//        for(int i = 0; i < curArray.length; i++){
//            char origin = curArray[i];
//            for(char c = 'a'; c <= 'z'; c++){
//                if(c == origin) continue;
//                curArray[i] = c;
//                String word = new String(curArray);
//                if(wordSet.contains(word)){
//                    temp.add(word);
//                    map.get(cur).add(word);
//                    if(word.equals(endWord)){
//                        flag = true;
//                    }else{
//                        q2.offer(word);
//                    }
//                }
//
//            }
//            curArray[i] = origin;
//        }
//        return flag;
//    }
//    public void dfs(String beginWord, String endWord, int index){
//        if(index == size - 1){
//            if(beginWord.equals(endWord)){
//                path.add(beginWord);
//                res.add(new ArrayList(path));
//                path.remove(path.size() - 1);
//            }
//            return;
//        }
//        path.add(beginWord);
//        Set<String> set = map.get(beginWord);
//        for(String word : set){
//            dfs(word, endWord, index+1);
//        }
//        path.remove(path.size() - 1);
//    }
//}









