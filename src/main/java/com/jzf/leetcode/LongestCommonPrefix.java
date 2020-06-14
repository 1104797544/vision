package com.jzf.leetcode;

/**
 * 最长公共前缀
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate
 * @see
 * @since V9.0
 */
public class LongestCommonPrefix {
    /**
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonStr = strs[0];
        int count = -1;
        here:
        for (int i = 0; i < commonStr.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(commonStr.charAt(i) + "")) {
                    break here;
                }
                strs[j] = strs[j].substring(1);
            }
            count = i;
        }
        return commonStr.substring(0, count + 1);
    }

}
