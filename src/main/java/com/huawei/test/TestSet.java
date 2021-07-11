package com.huawei.test;

import java.util.Iterator;
import java.util.TreeSet;

public class TestSet {

    static class Person implements Comparable {

        private Integer age;

        private String name;

        Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            Person target = (Person) o;
            return this.name.compareTo(target.name);
        }

        @Override
        public String toString() {
            return this.age + "@" + this.name;
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        Person person1 = new Person(13, "安琪拉");
        Person person2 = new Person(13,"后裔");
        treeSet.add(person1);
        treeSet.add(person2);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            System.out.println(person.toString());
        }
    }
}
