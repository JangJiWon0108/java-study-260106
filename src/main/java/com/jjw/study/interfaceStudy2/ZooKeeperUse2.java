package com.jjw.study.interfaceStudy2;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ZooKeeperUse2 {

    public Map<String, Object> zooKeeperUseTest() {
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        ZooKeeper zooKeeper = new ZooKeeper();

        return Map.of(
                "lion", Map.of("feed result", zooKeeper.feed(lion)),
                "tiger", Map.of("feed result", zooKeeper.feed(tiger))
        );
    }
}
