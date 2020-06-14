package com.jzf.leetcode;

import com.jzf.datastructure.demo.SegmentTree;
import com.jzf.leetcode.Interface.Merger;

/**
 * LeetCode 303 区域和检索-数组不可变
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/31
 * @see com.jzf.datastructure
 * @since V9.0
 */
public class RangeSumQuery {

    private SegmentTree<Integer> segmentTree;

    public RangeSumQuery(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merger(Integer e1, Integer e2) {
                    return e1 + e2;
                }
            });
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("");
        }
        return segmentTree.query(i, j);
    }

}
