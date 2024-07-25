package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import com.study.rest.entity.Product;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // componet를 IoC에 등록
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;

    // 자동 Override > ctrl + i
    @Override
    // 서비스에서 컨트롤러로 데이터를 전달할 때는 Dto로 전달 해주어야 함
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<Color> getColorListAll() {
        return colorMapper.findAll();
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {
        // dto에 있는 것을 product 객체에 넘겨줌.
        // service에서 repository로 넘어갈 때 객체가 DTO -> Entity로 전환
        // service에서 변환하여 넘겨주기 보다는 Dto 객체 내에서 entity로 변환하는 함수 호출
//        Product product = Product.builder()
//                .productName(register.getProductName())
//                .price(register.getPrice())
//                .sizeId(register.getSizeId())
//                .colorId(register.getColorId())
//                .build();
//        Product product = register.toEntity();
        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));
    }

    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
        int successCount = sizeMapper.save(reqRegisterSizeDto.toEntity());
        return CommonResponseDto.ofDefault(successCount);
    }
}
