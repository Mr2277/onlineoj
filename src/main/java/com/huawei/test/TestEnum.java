package com.huawei.test;

public class TestEnum {
    public static void main(String[] args) {
        SeasonEnum seasonEnum = SeasonEnum.SPRING;
        System.out.println(SeasonEnum.data.size());
        System.out.println(SeasonEnum.valueOf("SPRING"));
    }
}
