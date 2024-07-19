package com.example.smsprgwang.mapper;

import com.example.smsprgwang.dto.TbpostDto;

import java.util.List;

public interface TbpostMapper {
    TbpostDto.DetailResDto detail(TbpostDto.DetailReqDto param);
    List<TbpostDto.DetailResDto> list(TbpostDto.ListReqDto param);
    int pagedListCount(TbpostDto.PagedListReqDto param);
    List<TbpostDto.DetailResDto> pagedList(TbpostDto.PagedListReqDto param);
}
