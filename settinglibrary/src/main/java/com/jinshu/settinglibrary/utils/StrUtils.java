package com.jinshu.settinglibrary.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create on 2019/9/10 17:33 by bll
 */


public class StrUtils {

    /**
     * 判断给定字符串是否空白串 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     */
    public static boolean isEmpty(CharSequence input) {
        if (input == null || "".equals(input) || "null".equals(input) || "Null".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(String target) {
        if (target != null && target.length() > 0 && !target.equalsIgnoreCase("null") && !target.equals("")) {
            return true;
        }

        return false;
    }

    /**
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        if (isEmpty(str) || str.length() != 11)
            return false;

        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 当你输入信用卡号码的时候，有没有担心输错了而造成损失呢？其实可以不必这么担心，
     * 因为并不是一个随便的信用卡号码都是合法的，它必须通过Luhn算法来验证通过。该校验的过程：
     * 1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
     * 2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去9），再求和。
     * 3、将奇数位总和加上偶数位总和，结果应该可以被10整除。例如，卡号是：5432123456788881
     * 则奇数、偶数位（用红色标出）分布：5432123456788881奇数位和=35
     * 偶数位乘以2（有些要减去9）的结果：16261577，求和=35。最后35+35=70可以被10整除，认定校验通过。
     * 请编写一个程序，从键盘输入卡号，然后判断是否校验通过。通过显示：“成功”，否则显示“失败”。比如，用户输入：356827027232780
     * 程序输出：成功
     * <p>
     * 判断是否是银行卡号
     *
     * @param cardNo
     */
    public static boolean checkBankCard(String cardNo) {
        char bit = getBankCardCheckCode(cardNo
                .substring(0, cardNo.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardNo.charAt(cardNo.length() - 1) == bit;

    }

    private static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null
                || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            // 如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 格式化金额
     * @param amount 需要格式化的金额
     * @return 格式化后的金额
     */
    public static String formatMoney(double amount) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(amount);
    }
}
