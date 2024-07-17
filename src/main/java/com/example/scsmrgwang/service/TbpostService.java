package com.example.scsmrgwang.service;

import com.example.scsmrgwang.dto.TbpostDto;

public interface TbpostService {
    TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param);
}
