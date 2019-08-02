package com.guotu.gt.utils;


/**
 * 编码生成器
 *
 * @author YalandHong
 */

public class CodeGenerator {

    /**
     * 生成一个不重复的最小编码
     * @author siyang3 from LeetCode
     * @param originalCodeList 已有的编码列表
     * @return 生成Integer编码，如果异常则返回NULL
     */
    public static Integer getFirstMissingPositiveInteger(Integer[] originalCodeList) {
        if (originalCodeList == null || originalCodeList.length == 0) {
            return 0;
        }
        // 将Integer数组转化为int数组
        if (originalCodeList.length == Integer.MAX_VALUE) {  // 无可用的编码
            return null;
        }
        int[] codeList = new int[originalCodeList.length];
        for (int i = 0; i < codeList.length; i++) {
            codeList[i] = originalCodeList[i];
        }

        // 寻找不在列表中的最小正整数
        int n = codeList.length;
        for(int i = 0; i < n;){
            if(codeList[i] <= n && codeList[i] > 0 && codeList[codeList[i] - 1] != codeList[i]){
                swap(codeList, codeList[i] - 1, i);
            } else
                i++;
        }

        for(int i = 0; i < n; i++){
            if(codeList[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    /**
     * 交换两个数字
     * @param nums 数组
     * @param i 下标1
     * @param j 下标2
     */
    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
