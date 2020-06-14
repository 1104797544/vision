package com.jzf.leetcode;

/**
 * 翻转整数
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/3/15
 * @see com.jzf
 * @since V9.0
 */
public class ReverseInteger {

    //暴力 瞎jb解法
    public int reverseByMySelf(int x) {
        if (x == 0) {
            return x;
        }
        String str = x + "";
        String res = "";

        while (str.endsWith("0")) {
            str = str.substring(0, str.length() - 1);
        }
        for (int i = str.length() - 1; i > 0; i--) {
            res += str.charAt(i);
        }
        if (x < 0) {
            res = "-" + res;
        }
        Long resLong = Long.valueOf(res);
        if (resLong > Integer.MAX_VALUE || resLong < Integer.MIN_VALUE) {
            return 0;
        }
        return resLong.intValue();
    }

    public int reverse(int x) {
        int res = 0;
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
