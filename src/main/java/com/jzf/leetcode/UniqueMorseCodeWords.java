package com.jzf.leetcode;

import java.util.TreeSet;

/**
 * Leetcode 804 唯一摩斯密码词
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/28
 */
public class UniqueMorseCodeWords {

    public static final String[] CODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int solution(String[] words) {

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String morseCode = getMorseCode(word);
            set.add(morseCode);
        }
        return set.size();
    }

    public String getMorseCode(String word) {
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < word.length();i ++) {
            res.append(CODES[word.charAt(i) - 'a']);
        }
        return res.toString();
    }

}
