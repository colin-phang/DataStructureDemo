package com.colin.model;

/**
 * Created by Colin on 2017/5/4.
 */
public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    public int compareTo(Person person) {
        int compareName = name.compareTo(person.name);
        if (compareName != 0) {
            return compareName;
        }
        return age - person.age;
    }
}
