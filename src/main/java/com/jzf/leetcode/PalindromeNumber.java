package com.jzf.leetcode;

/**
 * 回文数
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/3/15
 * @see
 * @since V9.0
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int y = reverse(x);
        if (x == y) {
            return true;
        }
        return false;
    }

    public int reverse(int y) {
        int res = 0;
        int x = Math.abs(y);
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

}
