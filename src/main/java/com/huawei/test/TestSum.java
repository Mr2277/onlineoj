package com.huawei.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSum {

    static  class Lacation {
        Integer x;
        Integer y;
        Integer z;

        Lacation(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        /*
        double sum = 0d;
        sum = (153.58 + 124.40 + 20.50 + 27.60 + 27 + 126.27 + 74.34 + 26 + 22.40
                + 22.66 + 33.26 + 26.26 + 125.87 + 15.14 + 14.14 + 94.70 + 21.10
                + 98 + 102.4 + 22.4 + 102.43 + 55.43 + 23.4 + 45.2);
        System.out.println(sum);
        */
        List<Lacation> lacations = new ArrayList<>();
        Lacation A = new Lacation(1, 3);
        Lacation B = new Lacation(2, 0);
        lacations.add(A);
        lacations.add(B);

        List<Integer> zList = lacations.stream().map(lacation -> lacation.z).filter(z -> z != null)
                .distinct().collect(Collectors.toList());

        if (zList == null) {
            System.out.println("null");
        }
        else if (zList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(zList.get(0));
        }
    }
}
