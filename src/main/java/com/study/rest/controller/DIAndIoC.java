package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DIAndIoC {

    // Container 안에서 DAI에 C를 자동으로 주입해줌
    @Autowired
    private C c;

    @Autowired
    // Component로 Ioc콘테이너에 등록 시 카멜 표기법을 사용하여 자동으로 컴포넌드 이름 정의
//    @Qualifier("testServiceImpl")
    // 해당 class의 @Service 어노테이션에서 바로 컴포넌트 이름도 지정 가능
    @Qualifier("ts")
    private TestService testService1;

    @Autowired
    // Component로 Ioc콘테이너에 등록 시 카멜 표기법을 사용하여 자동으로 컴포넌드 이름 정의
//    @Qualifier("newTestServiceImpl")
    // 해당 class의 @Service 어노테이션에서 바로 컴포넌트 이름도 지정 가능
    @Qualifier("nts")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        // A가 B를 의존하는 관계
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }

        return null;
    }
}
