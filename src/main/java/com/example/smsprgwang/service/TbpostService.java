package com.example.smsprgwang.service;

import com.example.smsprgwang.dto.TbpostDto;

import java.util.List;

public interface TbpostService {
    TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param);
    TbpostDto.UpdateResDto update(TbpostDto.UpdateReqDto param);
    TbpostDto.DetailResDto detail(TbpostDto.DetailReqDto param);
    List<TbpostDto.DetailResDto> list(TbpostDto.ListReqDto param);

}
