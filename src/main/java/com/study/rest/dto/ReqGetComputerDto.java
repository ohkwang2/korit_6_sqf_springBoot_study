package com.study.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReqGetComputerDto {
    private int computerId;
    private String company;
    private String cpu;
    private int ram;
    private int ssd;
}
