package com.jjw.study.comparableStudy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonUse {

    public Map<String, Object> personUseTest() {
        Person person1 = new Person(20, 1);
        Person person2 = new Person(10, 2);

        int result = person1.compareTo(person2);
        String resultStr = "";

        if (result > 0) {
            resultStr = "person1 > person2";
        } else if (result < 0) {
            resultStr = "person1 < person2";
        } else {
            resultStr = "person1 = person2";
        }

        return Map.of(
                "person 1 와 2 비교", resultStr
        );
    }
}
