package com.study.rest.dto;

import com.study.rest.entity.Computer;
import lombok.Builder;
import lombok.Data;

import java.util.stream.Collectors;

@Builder
@Data
public class RespGetListDto {
    private int computerId;
    private String company;

//    public Computer toEntity() {
//        return Computer.builder()
//                .computerId(getComputerId())
//                .company(getCompany())
//                .cpu(getCpu())
//                .ram(getRam())
//                .ssd(getSsd())
//                .build();
//    }
}
