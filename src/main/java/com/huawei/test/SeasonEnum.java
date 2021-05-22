package com.huawei.test;

import java.util.HashMap;

public enum SeasonEnum {

    SPRING("spring", "春天"),

    SUMMER("summer", "夏天");

    private String englist;

    private String chiness;

    SeasonEnum(String englist, String chiness) {
        this.englist = englist;
        this.chiness = chiness;
    }

    public static HashMap<String, SeasonEnum> data = new HashMap<String, SeasonEnum>();

    static {
        for (SeasonEnum seasonEnum : SeasonEnum.values()) {
            data.put(seasonEnum.chiness, seasonEnum);
        }
    }

    public static SeasonEnum getSeason(String chiness) {
        return data.get(chiness);
    }

}
