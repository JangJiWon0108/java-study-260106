package com.jjw.study.controller;

import com.jjw.study.interfaceStudy1.ZooKeeperUse1;
import com.jjw.study.interfaceStudy2.ZooKeeperUse2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jiwon/interface")
@RequiredArgsConstructor
@Slf4j
public class InterfaceStudyController {

    private final ZooKeeperUse1 zooKeeperUse1;
    private final ZooKeeperUse2 zooKeeperUse2;

    @GetMapping("/study1")
    public Map<String, Object> interfaceStudy1() {

        return zooKeeperUse1.zooKeeperUseTest();

    }

    @GetMapping("/study2")
    public Map<String, Object> interfaceStudy2() {

        return zooKeeperUse2.zooKeeperUseTest();

    }

}
