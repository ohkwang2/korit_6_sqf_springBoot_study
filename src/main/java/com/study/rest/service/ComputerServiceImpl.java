package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl implements ComputerService{

    @Autowired
    private ComputerMapper computerMapper;

    @Override
    public int registerComputer(ReqRegisterComputerDto reqDto) {
        return computerMapper.save(reqDto.toEntity());
    }

//    foreach 사용 할 경우
//    @Override
//    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
//        List<RespGetListDto> respDtos = new ArrayList<>();
//        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(reqDto.getEntity());
//        for(Computer com : computers) {
//            RespGetListDto dto = RespGetListDto.builder()
//                    .computerId(com.getComputerId())
//                    .company(com.getCompany())
//                    .build();
//            respDtos.add(dto);
//        }
//        return respDtos;
//    }

    // stream 사용할 경우
    @Override
    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
        List<RespGetListDto> respDtos = new ArrayList<>();
        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(reqDto.getEntity());

        return computers.stream().map(com -> RespGetListDto.builder()
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
            ).collect(Collectors.toList());
    }

    @Override
    public RespGetComputerDto getComputerDto(int computerId) {
        Computer computer = computerMapper.findComputerById(computerId);
        return RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    public int deleteComputer(int computerId) {
        return computerMapper.delete(computerId);
    }

    public int updateComputer(ReqUpdateComputerDto reqDto) {
        Computer computer = Computer.builder()
                .computerId(reqDto.getComputerId())
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();
        return computerMapper.update(computer);
    }
}
