package com.study.rest.controller;

import com.study.rest.di.무기;
import com.study.rest.di.방패;
import com.study.rest.di.칼;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.TypedValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class 캐릭터 {

    @Autowired
    @Qualifier("총")
    private 무기 weapon;
    @Autowired
    @Qualifier("물리공격방패")
    private 방패 shield;

    // 직접 생성한 메소드도 Bean에 등록하여 Autowired해서 사용 가능
    // 단, Configuration 어노테이션이 등록된 클래스에서만 등록 가능
    @Autowired
    private TypedValue typedValue;

    @ResponseBody
    @GetMapping("/maple/attack")
    public Object mapleAttack() {
//        weapon = new 칼();   // 결합도가 높은 코드
        weapon.공격();
        return null;
    }

    @ResponseBody
    @GetMapping("/maple/defence")
    public Object mapleDefence() {
        shield.방어();
        return null;
    }
}
