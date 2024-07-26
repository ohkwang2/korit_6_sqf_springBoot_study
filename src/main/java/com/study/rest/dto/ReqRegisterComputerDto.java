package com.study.rest.dto;

import com.study.rest.entity.Computer;
import lombok.Data;

@Data
public class ReqRegisterComputerDto {
    private String company;
    private String cpu;
    private int ram;
    private int ssd;

    public Computer toEntity() {
        return Computer.builder()
                .company(company)
                .cpu(cpu)
                .ram(ram)
                .ssd(ssd)
                .build();

    }
}
