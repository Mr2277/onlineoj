package com.huawei.leetcode.leetcode1_1000.leetcode601_700.leetcode681_690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode690 {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;


    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return dfs(employeeMap.get(id), employeeMap);
    }

    public static int dfs(Employee employee, Map<Integer, Employee> employeeMap) {
        if (employee.subordinates.isEmpty()) {
            return employee.importance;
        }
        int sum = employee.importance;
        for (Integer integer : employee.subordinates) {
            sum += dfs(employeeMap.get(integer), employeeMap);
        }
        return sum;
    }


    public static void main(String[] args) {

    }

}
