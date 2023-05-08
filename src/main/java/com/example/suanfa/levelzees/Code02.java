package com.example.suanfa.levelzees;

/**
 * 题目2：一个数组中只有两种字符G和B，想让所有的G都放在左侧，B放在右侧或者  G在右侧，B在左侧
 * 但是只能在相邻字符之间进行交换操作，返回至少需要交换几次？
 * @author Elliot Ji
 * @date 2023/5/4
 */
public class Code02 {

    /**
     * 方法一：
     * @param s
     * @return
     */
    public static int minStep1(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step1 = 0;
        int gi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') {
                step1 += i - (gi++);
            }
        }
        int step2 = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'B') {
                step2 += i - (bi++);
            }
        }
        return Math.min(step1,step2);
    }

    /**
      *方法二：
      *
      */
    public static int minStep2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step1 = 0;
        int step2 = 0;
        int gi = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') {
                step1 += i - (gi++);
            }else {
                step2 += i = (bi++);
            }
        }
        return Math.min(step1,step2);
    }

}
