package com.huawei.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {

    private static Map<String, String> useMap = new HashMap<>();

    private static Map<String, String> releaseMap = new HashMap<>();

    private static int count = 0;

    private static String preIp = "192.168.0.";

    public static String useApply(String mac) {
        String ip = "NA";
        if (count > 3) {
            if (useMap.size() >= 4) {
                return ip;
            } else {
                String key = "";
                int min = Integer.MAX_VALUE;
                String minKey = "";
                String value = "";
                int endNum = 0;
                Iterator iterator = releaseMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    key = (String) entry.getKey();
                    value = (String) entry.getValue();
                    String[] values = value.split("\\.");
                    endNum = Integer.valueOf(values[3]);
                    if (endNum < min) {
                        min = endNum;
                        minKey = key;
                    }

                }
                ip = releaseMap.get(minKey);
                releaseMap.remove(minKey);
                useMap.put(mac, ip);
            }
        }
        if (!useMap.containsKey(mac)) {
            if (!releaseMap.containsKey(mac)) {
                ip = preIp + count;
                count ++;
                useMap.put(mac, ip);
            } else {
                ip = releaseMap.get(mac);
                releaseMap.remove(mac);
                useMap.put(mac, ip);
            }
        } else {
            ip = useMap.get(mac);
        }
        // System.out.println(count);

        return ip;
    }



    public static void release(String mac) {
        String ip = useMap.get(mac);
        releaseMap.put(mac, ip);
        useMap.remove(mac);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int i = 0;
            String[] strings = new String[n];
            for (i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }
            for (i = 0; i < n; i++) {
                String str = strings[i];
                String[] strs = str.split("=");
                if (strs[0].equals("use")) {
                    System.out.println(useApply(strs[1]));
                } else {
                    release(strs[1]);
                }

            }
        }
    }
}
