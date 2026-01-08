package com.jjw.study.controller;

import com.jjw.study.anonymousStudy1.RectangleUse1;
import com.jjw.study.anonymousStudy2.PersonYUse2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jiwon/anonymous")
@Slf4j
@RequiredArgsConstructor
public class anonymousStudy {
    private final RectangleUse1 rectangleUse1;
    private final PersonYUse2 personYUse2;

    @GetMapping("/use1")
    public String anonymousStudy1() {
        return rectangleUse1.rectangleUseTest();
    }

    @GetMapping("/use2")
    public String anonymousStudy2() {
        return personYUse2.personYUseTest();
    }
}
