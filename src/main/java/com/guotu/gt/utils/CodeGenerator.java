package com.guotu.gt.utils;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * 编码生成器
 *
 * @author YalandHong
 */

public class CodeGenerator {

    /**
     * 根据现有的编码列表，生成一个不重复的最小编码
     * 函数会对传入的编码列表进行排序
     *
     * @param firstValue 第一个合法的编码值
     * @param codeList 已有的编码列表
     * @return 生成编码，如果异常则返回NULL
     */
    public static Byte byteCodeGenerator(final Byte firstValue, Byte[] codeList) {
        Arrays.sort(codeList);
        Byte code = firstValue;
        while (true) {
            if (Arrays.binarySearch(codeList, code) < 0) {  // 有效编码
                break;
            }
            if (code.equals(Byte.MAX_VALUE)) {  // 角色编码生成异常
                return null;
            }
            code = (byte) (code + 1);
        }
        return code;
    }
}
