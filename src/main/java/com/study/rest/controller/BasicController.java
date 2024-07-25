package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// REST API
/*
    REST API
    데이터 통신을 위한 HTTP 요청 방식
    HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
    1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자
        - 데이터 추가(등록)은 POST 요청으로 하자
          그리고 POST 요청은 JSON 데이터로 요청하자
        - 데이터 조회는 GET 요청으로 하자
          그리고 GET 요청은 QueryString(params)으로 요청하자
          ex) 주소?key1=value1&key2=value2
        - 데이터 수정은 PUT, PATCH 요청으로 하자
          그리고 PUT 요청은 JSON 데이터로 요청하자
            ·PUT요청과 PATCH 요청의 차이점
             PUT 요청은 공백 또는 NULL인 데이터도 수정을 함
             PATCH 요청은 공백 또는 NULL인 데이터는 수정하지 않음
        - 데이터 삭제는 DELETE 요청으로 하자
          그리고 DELETE 요청은 params로 요청하자
    2. 주소(URL), 요청 메세지(Resource) 자원 작성법
        - URL은 가능한 동사를 사용하지 않는다.
        - 계층 구조로 작성한다.
          ex) /집/주방/가스레인지, /식당/주방/가스레인지
        - 요청 메소드 마다 작성하는 방법이 다르다. (요청 메소드에 따라 구분됨)
          ex) 상품 등록(POST) -> /product
              상품 하나(단건) 조회(GET) -> /product/1(id or key)
              상품 여러개(다건) 조회(GET) -> /products(전체 조회), /products?page=1&count=30(한 페이지에 30개씩 가져오는 조회)
              상품 수정(PUT) -> /product/1(id or key)
              상품 삭제(DELETE) -> /product/1(id or key)
    3. 주소는 가능한 대문자를 사용하지 않는다.
 */
// 데이터 요청 응답 방식
// 데이터만 요청하고 데이터만 받음
// RestController를 붙일 경우 Responsebody를 안 붙이고도 데이터를 전달할 수 있음
@Slf4j  //로그를 찍을 때 쓸 수 있는 어노테이션 (서버를 켜고 끌때까지 로그들이 파일로 내보낼 수 있음) (특히 예외 발생 시 무조건 남겨야 함)
@RestController
public class BasicController {

    @Autowired
    private ProductService productService;

    // 이거 하나 하나를 하나의 기능을 가진 프로그램이라고 함
    // CRUD에 해당하는 것은 맵핑 주소 자체가 아닌 METHOD로 관리함
    @CrossOrigin
    @PostMapping("/basic/student")
    // @RequestBody가 달려 있어야 JSON으로 받을 수 있음 (그 이후 Jackson이 데이터를 Dto로 옮겨줌)
    // @Pharams는 아님
    // ResponseEntity<> <- 응답 데이터의 타입을 제네릭 형태로 사용
    // ResponseEntity 객체(header와 body 정보를 넣어줌)를 리액트에서 응답 받아서 view에 해당하는 역할을 리액스 서버에서 처리
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {
        log.info("Student : {}", reqStudentDto);  // {}중괄호 안으로 매개변수의 값이 들어가게 됨
        //항상 return은 객체 형태로 해주어야 함
        // ResponseEntity를 생성하지 않아도 해당 객체의 메소드는 static으로 선언되어 있어 바로 참조하여 사용 가능
        return ResponseEntity.badRequest().body("응답데이터 : " + reqStudentDto.toString());   // ok -> 상태코드 200
    }

    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> basicPost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("Teacher : {}", reqTeacherDto);
        return ResponseEntity.ok().body("응답데이터 : " + reqTeacherDto.toString());
    }

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
//        log.info("요청온 데이터는 : {}", reqProductDto);
        // C (DTO) -> S (DTO) -> R (Entity) -> DB
        CommonResponseDto commonResponseDto = productService.registerProduct(register);
        return  ResponseEntity.ok().body(commonResponseDto);
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> registerSizeApi(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        log.info("{}", reqRegisterSizeDto);
        CommonResponseDto commonResponseDto = productService.registerSize(reqRegisterSizeDto);
        return ResponseEntity.ok().body(commonResponseDto);
    }
}
