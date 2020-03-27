package com.baidu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_17_LetterCombinations {

    public static Map<String, String> reflectMap = new HashMap<String, String>() {{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    public List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("") || digits == null) {
            return res;
        } else {
            letterRecur("", digits);
        }
        return res;
    }

    public void letterRecur(String cur, String digits) {
        if (digits.length() < 2) {
            String val = reflectMap.get(digits);
            for (int i = 0; i < val.length(); i++) {
                res.add(cur + val.substring(i, i + 1));
            }
        } else {
            String val = reflectMap.get(digits.substring(0,1));
            for (int i = 0; i < val.length(); i++) {
                String tmp = val.substring(i, i + 1);
                letterRecur(cur + tmp, digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        String in = "23";
        System.out.println(new Code_17_LetterCombinations().letterCombinations(in));
    }
}
