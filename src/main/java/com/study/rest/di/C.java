package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

    // false로 바꾸면 서버 실행은 되지만, 호출시 오류 발생
//    @Autowired(required = false)
    @Autowired
    private D d;

    public void cCall() {
        System.out.println("C 객체에서 메소드 호출");
        d.dCall();
    }

}
