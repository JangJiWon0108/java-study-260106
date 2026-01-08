package com.jjw.study.controller;

import com.jjw.study.comparableStudy.PersonUse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jiwon/comparable")
@Slf4j
@RequiredArgsConstructor
public class ComparableStudyControlelr {

    private final PersonUse personUse;

    @GetMapping("")
    public Map<String, Object> comparableStudy() {
        return personUse.personUseTest();
    }
}
