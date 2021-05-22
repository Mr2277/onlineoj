package com.huawei.utils;

public class CodeEnumTestUtil {
    public static <E extends Enum<?>> E codeOf(Class<E> enumClass, int code) {
        return enumClass.getEnumConstants()[0];
    }
}
