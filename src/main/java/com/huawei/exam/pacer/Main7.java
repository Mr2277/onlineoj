package com.huawei.exam.pacer;

import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            //Map<String,Integer> map = new HashMap<String, Integer>();
            Map<String, Integer> map = new TreeMap<String, Integer>(
                    new Comparator<String>() {
                        public int compare(String o1, String o2) {
                            return o1.compareTo(o2);
                        }
                    }
            );
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (map.isEmpty()) {
                    count++;
                    map.put(String.valueOf(ch), count);
                } else {
                    if (map.get(String.valueOf(ch)) != null) {
                        count = map.get(String.valueOf(ch));
                        count++;
                        map.put(String.valueOf(ch), count);
                    } else {
                        count = 1;
                        map.put(String.valueOf(ch), count);
                    }
                }
            }
        /*
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.print(key+":"+value+" ");
        }
        */
            //这里将map.entrySet()转换成list
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            //然后通过比较器来实现排序
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                //升序排序
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<String, Integer> mapping : list) {
                Object key = mapping.getKey();
                Object value = mapping.getValue();
                System.out.print(key);
            }
            System.out.println();
        }

    }
}
