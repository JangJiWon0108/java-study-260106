package com.jjw.study.comparatorStudy;

import java.util.Comparator;

public class PersonX implements Comparator<PersonX> {
    Integer age;
    Integer classNumber;

    PersonX(Integer age, Integer classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    public int compare(PersonX p1, PersonX p2) {
        if (p1.age > p2.age) {
            return 1;
        } else if (p1.age < p2.age) {
            return -1;
        } else {
            return 0;
        }
    }
}
