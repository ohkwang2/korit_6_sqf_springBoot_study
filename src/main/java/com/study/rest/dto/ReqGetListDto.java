package com.study.rest.dto;

import com.study.rest.entity.Computer;
import lombok.Data;

@Data
public class ReqGetListDto {
    private String company;
    private String cpu;

    public Computer getEntity() {
        return Computer.builder()
                .company(company)
                .cpu(cpu)
                .build();
    }
}
