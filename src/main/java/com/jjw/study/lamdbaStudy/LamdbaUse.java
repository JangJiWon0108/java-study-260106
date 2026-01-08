package com.jjw.study.lamdbaStudy;

import org.springframework.stereotype.Component;

@Component
public class LamdbaUse {

    public String lamdbaUseTest() {

//        // 1-1. 익명 객체를 이용
//        MyInterface myInterface1 = new MyInterface() {
//            @Override
//            public int max(int a, int b) {
//                if (a>b) {
//                    return a;
//                } else {
//                    return b;
//                }
//            }
//        };
//
//        // 1-2. 람다 이용
//        MyInterface myInterface2 = (int a, int b) -> {
//            if (a>b) {
//                return a;
//            } else {
//                return b;
//            }
//        };
//
//        return "10, 20 중 큰 것은 ?\n(익명객체) : " + myInterface1.max(10, 20) + "\n(람다) : " + myInterface2.max(10, 20);


        // 2. 매개변수, 리턴
        String resultStr = "";

        // 2-1. 익명 객체 생성
        MyInterface x1 = new MyInterface() {
            @Override
            public String run() {
                return "x1 run\n";
            }
        };

        // 2-2. 람다 생성
        MyInterface x2 = () -> "x2 run\n";

        // x1 실행
        resultStr += execRun(x1);

        // x2 실행
        resultStr += execRun(x2);

        // x3 생성 및 실행 (익명)
        MyInterface x3 = returnAnony();
        resultStr += execRun(x3);

        // x4 생성 및 실행 (람다)
        MyInterface x4 = returnLamdba();
        resultStr += execRun(x4);

        return resultStr;
    }

    // 함수형 인터페이스(익명객체/람다) 를 매개변수로 받아 run 호출
    public static String execRun(MyInterface x) {
        return x.run();
    }

    // 익명객체 를 return
    public static MyInterface returnAnony() {
        return new MyInterface() {
            @Override
            public String run() {
                return "x3 run\n";
            }
        };
    }

    // 람다를 return
    public static MyInterface returnLamdba() {
        return () -> "x4 run\n";
    }
}
