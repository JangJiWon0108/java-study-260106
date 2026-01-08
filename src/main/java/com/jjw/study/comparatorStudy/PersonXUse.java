package com.jjw.study.comparatorStudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class PersonXUse {

    public Map<String, Object> personXUseTest() {

        log.info("comparator test");

        PersonX p1 = new PersonX(1, 1);
        PersonX p2 = new PersonX(10, 2);
        PersonX p3 = new PersonX(20, 3);

        int result = p1.compare(p2, p3);
        String resultStr = "";

        if (result > 0) {
            resultStr = "person2 > person3";
        } else if (result < 0) {
            resultStr = "person2 < person3";
        } else {
            resultStr = "person2 = person3";
        }

        return Map.of(
                "person 2 (10) 와 3 (20) 비교", resultStr
        );
    }


}
