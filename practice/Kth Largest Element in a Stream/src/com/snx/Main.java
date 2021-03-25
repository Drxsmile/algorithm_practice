package com.snx;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        KthLargest k = new KthLargest(3, nums);
        System.out.println("....");
        for(int x : k.minHeap){
            System.out.println(x);
        }
        System.out.println(k.add(1));
        System.out.println("....");
        for(int x : k.minHeap){
            System.out.println(x);
        }
        System.out.println(k.add(1));
        System.out.println("....");
        for(int x : k.minHeap){
            System.out.println(x);
        }
        System.out.println(k.add(3));
        System.out.println(k.add(3));
        System.out.println(k.add(3));
        k.add(4);
        k.add(4);
        k.add(4);
    }
    static class KthLargest {
        PriorityQueue<Integer> minHeap;
        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return a - b;
                }
            });

            for(int i = 0; i < k; i++){
                if(i < nums.length)
                    minHeap.offer(nums[i]);
                else
//                    minHeap.offer(-100000);
                    minHeap.offer(Integer.MIN_VALUE);
            }
            for(int i = k; i < nums.length; i++){
                if(nums[i] > minHeap.peek()){

                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }

        }

        public int add(int val) {
            System.out.println("top:" + minHeap.peek());
            if(val > minHeap.peek()){
                System.out.println("add");
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }
}
