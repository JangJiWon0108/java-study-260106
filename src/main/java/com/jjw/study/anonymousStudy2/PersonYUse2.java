package com.jjw.study.anonymousStudy2;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;

@Component
public class PersonYUse2 {

    public String personYUseTest() {
        PersonY p1 = new PersonY(10, 2);
        PersonY p2 = new PersonY(20, 3);

        int result = comp.compare(p1, p2);
        String resultStr = "";

        if (result > 0) {
            resultStr = "person1 > person2";
        } else if (result < 0) {
            resultStr = "person1 < person2";
        } else {
            resultStr = "person1 = person2";
        }

        return "익명객체 사용 --- p1(10), p2(20) : " + resultStr;
    }

    // 익명객체
    public static Comparator<PersonY> comp = new Comparator<PersonY>() {
        @Override
        public int compare(PersonY p1, PersonY p2) {
            if (p1.age > p2.age) {
                return 1;
            } else if (p1.age < p2.age) {
                return -1;
            } else {
                return 0;
            }
        }
    };

}
