package com.huawei.test;

import com.huawei.utils.CodeEnumUtil;

public class TestEnum {
    public static void main(String[] args) {
        SeasonEnum seasonEnum = SeasonEnum.SPRING;
        System.out.println(SeasonEnum.data.size());
        System.out.println(SeasonEnum.valueOf("SPRING"));

        ComputerState computerState = CodeEnumUtil.codeOf(ComputerState.class, 255);
        System.out.println(computerState);
        System.out.println(computerState);
    }
}
