package com.jzf.leetcode;

import java.util.Stack;

/**
 * Leetcode 20 有效的括号
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/19
 */
public class ValidBrackets {

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        if ("".equals(s))
            return true;
        String[] strs = s.split("");
        for (int i = 0; i < strs.length; i++) {
            if ("[".equals(strs[i]) || "{".equals(strs[i]) || "(".equals(strs[i])) {
                stack.push(strs[i]);
            } else {
                if (!stack.isEmpty()) {
                    String top = stack.peek();
                    if ("[".equals(top) && "]".equals(strs[i])) {
                        stack.pop();
                        continue;
                    } else if ("{".equals(top) && "}".equals(strs[i])) {
                        stack.pop();
                        continue;
                    } else if ("(".equals(top) && ")".equals(strs[i])) {
                        stack.pop();
                        continue;
                    }
                } {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char come = s.charAt(i);
            if (come == '[' || come == '{' || come == '(') {
                stack.push(come);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top == '[' && come != ']') {
                    return false;
                }
                if (top == '{' && come != '}') {
                    return false;
                }
                if (top == '(' && come != ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValid2(str));
    }
}
