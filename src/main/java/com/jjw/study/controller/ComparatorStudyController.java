package com.jjw.study.controller;

import com.jjw.study.comparableStudy.PersonUse;
import com.jjw.study.comparatorStudy.PersonXUse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jiwon/comparator")
@Slf4j
@RequiredArgsConstructor
public class ComparatorStudyController {

    private final PersonXUse personXUse;

    @GetMapping("")
    public Map<String, Object> comparableStudy() {
        return personXUse.personXUseTest();
    }
}
