package com.study.rest.service;

import com.study.rest.dto.*;

import java.util.List;

public interface ComputerService {
    int registerComputer(ReqRegisterComputerDto reqDto);
    int deleteComputer(int computerId);
    int updateComputer(ReqUpdateComputerDto reqDto);
    List<RespGetListDto> getComputerList(ReqGetListDto reqDto);
    RespGetComputerDto getComputerDto(int computerId);
}
