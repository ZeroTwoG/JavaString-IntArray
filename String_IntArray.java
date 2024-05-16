package io.gethub.zerotwog.entiy;

/**
 * @program: untitled
 * @description:字符串类型转换;
 * @author: Zero
 * @create:
 **/
public class String_IntArray {


    //    字符串转整数数组
    public int[] StringIntArray(String st) {
        int[] it = new int[100];
        int nmb = 0;
        for (char c : st.toCharArray()) {
            //判断字符  45 - -2        46 . -1
            it[nmb] = c >= 48 && c <= 57 ? (int) c - 48 + (++nmb - nmb) : c == 45 ? -2 + (++nmb - nmb) : -3 + (++nmb - nmb);
        }
        int[] in = new int[nmb];
        int nmbs = 0, cuts = 0, dot = 0, dots = 0, doutss = 0;
        //nmbs新数组的归纳个数//cuts cut判断数字前是否有负号//dot判断小数点//dots判断是否字符相连//doutss判断字符是否相连
        int cut = 1;
        for (int i = 0; i < nmb; i++) {
            //判断符号 数字 进行数组赋值
            //字符和点的去除
            if (dot != 0) {
                //首次遇到字符将之前数字进行打包 然后开启第二格 数
                try {
                    in[nmbs] *= (it[i - 2] == -2 || it[i - 2] == -3) ? 1 : (dot == -1) ? cut + (++nmbs - nmbs) : 1;
                } catch (Exception e) {
                }
                cut = cuts == -1 ? (cuts = 1) - 2 : cut;
                dot = it[i] == -3 ? 1 + (++dots - dots) + (cut = 1) - 1 : it[i] == -2 ? (++dots - dots) + (cut = -1) + 1 : it[i - 1] == -2 ? 0 * (--i) : 0 * (--i) + (cut = 1) - 1;
//                判断字符/点是否连续
                dot = (dots != 0) ? ++doutss != dots ? 0 + (--i - i) : dot : dot;
            } else {
                //正常赋值并判断是否符合输入相加条件,如果有字符则i-1跳转上方字符和点去除操作
                in[nmbs] = (it[i] == -3) ? in[nmbs] + ((dot = -1) + 1) : it[i] == -2 ? in[nmbs] + ((dot = -1) + 1) + (cuts = -1) + 1 : (in[nmbs] * 10) + it[i];
//                正常归零字符判断
                doutss = dots = 0;
            }
            in[nmbs] *= (i == nmb - 1) ? cut : 1;
            if (it[nmb] < 0 && it[nmb - 1] < 0) {
                nmbs -= 1;
            }
        }
        if ((it[nmb - 1] == -3 || it[nmb - 1] == -2) && (it[nmb - 2] == -3 || it[nmb - 2] == -2)) {
            nmbs -= 1;
        }
        int[] ints = new int[nmbs + 1];
        for (int i = 0; i <= nmbs; i++) {
            ints[i] = in[i];
        }
        return ints;
    }
}
