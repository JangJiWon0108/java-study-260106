package com.jjw.study.anonymousStudy1;

import org.springframework.stereotype.Component;

@Component
public class RectangleUse1 {

    public String rectangleUseTest() {
        // 1. 익명 객체 사용 X
        //        Rectangle r = new Rectangle();
//        ChildRectangle cr = new ChildRectangle();
//
//        return "rectangle get : " + r.get() + ", child rectangle get : " + cr.get();

        // 2. 익명 객체 사용 O
        Rectangle r = new Rectangle();

        Rectangle anonymous = new Rectangle() {
            @Override
            int get() {
                return this.width * this.heignt;
            }
        };

        return "rectangle get : " + r.get() + ", anonymous rectangle get : " + anonymous.get();
    }
}
