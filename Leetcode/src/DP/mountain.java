package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 22787 on 2018/6/3.
 */
public class mountain {
    public static void main(String[] args) {


        List<String> ls=new ArrayList<>();
        ls.add("leet");
        ls.add("code");

        boolean flag= wordBreak("leetcode",ls);
        System.out.print(flag);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // 参数校验
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        // 标记是否匹配，match[i]表表[0, i-1]都匹配
        int length = s.length();
        boolean[] match = new boolean[length + 1];
        match[0] = true;

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    // f(0,n) = f(0,i) + f(i,j) + f(j,n)
                    match[i] = true;
                    break;
                }
            }
        }


        return match[length];
    }

}
