package com.huawei.exam.pacer;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                }
        );
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                int num = 0;
                if (map.get(String.valueOf(ch)) == null) {
                    num ++;
                    map.put(String.valueOf(ch),num);
                } else {
                    num = map.get(String.valueOf(ch));
                    num ++;
                    map.put(String.valueOf(ch),num);
                }
            }
            //这里将map.entrySet()转换成list
            List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
            //然后通过比较器来实现排序
            Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
                //升序排序
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for(Map.Entry<String,Integer> mapping:list){
                System.out.print(mapping.getKey());
            }
            /*
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key+"#"+value);
            }
            */
        }
    }
}
