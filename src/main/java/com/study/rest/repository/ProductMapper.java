package com.study.rest.repository;

import com.study.rest.entity.Color;
import com.study.rest.entity.Product;
import com.study.rest.entity.Size;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 어떤 객체를 save할 것인지 매개변수로 들어가야 함
    int save(Product product);
}