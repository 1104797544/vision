package com.jzf.leetcode;

import com.jzf.datastructure.PriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode 347 前K个高频元素
 * 思路:1.先用TreeMap存储元素与元素出现的次数(元素值为key,出现次数为value)
 *     2.维护一个长度为k的优先队列(按照出现次数排列,队列中次数最少的排在队首)
 *     3.将元素TreeMap中的元素依次入队(如果队列长度达到k,则需要将元素与队首的元素进行比较，若大于队首的元素则入队 否则不入队)
 *     4.将队列中所有元素出队
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/31
 * @see com.jzf.datastructure
 * @since V9.0
 */
public class TopKFrequentElements {

    public class Freq implements Comparable<Freq> {
        private Integer e;
        private Integer count;

        public Freq(Integer e, Integer count) {
            this.e = e;
            this.count = count;
        }

        /**
         * 因为使用的优先队列的实现方式是最大堆(优先级最高的排在队首),所以这里元素的比较要是逆序的
         * @param another
         * @return
         */
        @Override
        public int compareTo(Freq another) {
            if (this.count < another.count) {
                return 1;
            } else if (this.count > another.count ) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * 使用最大堆实现的优先队列实现
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        //1.遍历数组,使用TreeMap存储元素与元素出现的次数(元素值为key,出现次数为value)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                Integer count = treeMap.get(nums[i]);
                treeMap.put(nums[i], count + 1);
            } else {
                treeMap.put(nums[i], 1);
            }
        }

        //2.维护一个长度为k的优先队列(按照出现次数排列,队列中次数最少的排在队首)
        //3.将元素TreeMap中的元素依次入队(如果队列长度达到k,则需要将元素与队首的元素(队首的元素的count值最小)进行比较，若大于队首的元素则入队 否则不入队)
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (Integer key : treeMap.keySet()) {
            if (queue.getSize() < k) {
                Integer count = treeMap.get(key);
                queue.enqueue(new Freq(key, count));
            } else {
                //if (come.compareTo(queue.getFront()) < 0) {
                if (treeMap.get(key) > queue.getFront().count) {
                    queue.dequeue();
                    Freq come = new Freq(key, treeMap.get(key));
                    queue.enqueue(come);
                }
            }
        }

        //4.将队列中所有元素出队
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!queue.isEmpty()) {
            linkedList.add(queue.dequeue().e);
        }
        return linkedList;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {

        //1.遍历数组,使用TreeMap存储元素与元素出现的次数(元素值为key,出现次数为value)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                Integer count = treeMap.get(nums[i]);
                treeMap.put(nums[i], count + 1);
            } else {
                treeMap.put(nums[i], 1);
            }
        }

        //2.维护一个长度为k的优先队列(按照出现次数排列,队列中次数最少的排在队首)
        //3.将元素TreeMap中的元素依次入队(如果队列长度达到k,则需要将元素与队首的元素(队首的元素的count值最小)进行比较，若大于队首的元素则入队 否则不入队)
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(
                //匿名比较器的简写方式
                (a, b) -> treeMap.get(a) - treeMap.get(b)
        );
        for (Integer key : treeMap.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else {
                if (treeMap.get(key) > treeMap.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }
        }

        //4.将队列中所有元素出队
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!queue.isEmpty()) {
            linkedList.add(queue.remove());
        }
        return linkedList;
    }


    public static void main(String[] args) {
        int[] nums = {7,4,1,-1,2,-1,2,3,4,4,4,2,2,2,2,2,5,6,3,3,3,3,3,3,3,3,3,3,3};
        int k = 3;
        new TopKFrequentElements().topKFrequent(nums, k);
        //java.util.PriorityQueue
    }


}
