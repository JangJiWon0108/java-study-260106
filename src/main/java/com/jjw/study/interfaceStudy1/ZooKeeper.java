package com.jjw.study.interfaceStudy1;

import org.springframework.stereotype.Component;

import java.util.Map;

public class ZooKeeper {

    public String feed(Lion lion) {
        return "feed lion!";
    }

    public String feed(Tiger tiger) {
        return "feed tiger!";
    }

}
