package com.huawei.exam.pacer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> negative = new ArrayList<Integer>();
        List<Integer> positive = new ArrayList<Integer>();
        while(scanner.hasNext()) {
            int a = scanner.nextInt();
            if(a < 0) {
                negative.add(a);
            } else {
                positive.add(a);
            }
        }
        if(positive.isEmpty()) {
            System.out.println(negative.size());
            System.out.println("0.0");
        } else {
            double sum = 0;
            for(Integer integer : positive) {
                sum += integer;
            }
            System.out.println(negative.size());

            double result = sum / positive.size();
            System.out.println(String.format("%.1f", result));
            //System.out.println("%.1f", result);
        }
    }
}
