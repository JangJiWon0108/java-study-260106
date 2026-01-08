package com.jjw.study.comparableStudy;

public class Person implements Comparable<Person> {
    Integer age;
    Integer classNumber;

    Person(Integer age, Integer classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override
    public int compareTo(Person person) {

        if (this.age > person.age) {
            return 1;
        } else if (this.age < person.age) {
             return -1;
        } else {
            return 0;
        }

    }
}
