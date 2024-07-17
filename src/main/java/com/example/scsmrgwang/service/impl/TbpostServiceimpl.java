package com.example.scsmrgwang.service.impl;

import com.example.scsmrgwang.domain.Tbpost;
import com.example.scsmrgwang.dto.TbpostDto;
import com.example.scsmrgwang.repository.TbpostRepository;
import com.example.scsmrgwang.service.TbpostService;
import org.springframework.stereotype.Service;

@Service
public class TbpostServiceimpl implements TbpostService {

    private TbpostRepository tbpostRepository;
    public TbpostServiceimpl(TbpostRepository tbpostRepository) { this.tbpostRepository = tbpostRepository; }

    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param){

        /* 첫번째 방법( 이후 Tbpost에 protected로 생성자 만들면 작동안됨 )
        Tbpost tbpost = new Tbpost();
        tbpost.setTitle(param.getTitle());
        tbpost.setAuthor(param.getAuthor());
        tbpost.setContent(param.getContent());

        tbpostRepository.save(tbpost);

        TbpostDto.CreateResDto createResDto = new TbpostDto.CreateResDto();
        createResDto.setId(tbpost.getId());

        return createResDto;*/

        /* 두번째 방법 (TbpostDto.CreateRequDto에 toEntity()메소드 만들기, tbpost에 toCreateResDto()메소드 만들기)
        Tbpost tbpost = tbpostRepository.save(param.toEntity());
        TbpostDto.CreateResDto createResDto = tbpost.toCreateResDto();

        return createResDto;*/

        //세번째 (간단히)
        Tbpost tbpost = tbpostRepository.save(param.toEntity());

        return tbpost.toCreateResDto();
    }

    public TbpostDto.DetailResDto detail(TbpostDto.DetailReqDto param){

        Tbpost tbpost = tbpostRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("No Data"));
        TbpostDto.DetailResDto detailResDto = TbpostDto.DetailResDto.builder()
                .id(tbpost.getId())
                .deleted(tbpost.getDeleted())
                .process(tbpost.getProcess())
                .createAt(tbpost.getCreatedAt() + "")
                .modifiedAt(tbpost.getModifiedAt() + "")
                .title(tbpost.getTitle())
                .author(tbpost.getAuthor())
                .content(tbpost.getContent())
                .build();

        return detailResDto;
    }

    public TbpostDto.UpdateResDto update(TbpostDto.UpdateReqDto param){

        Tbpost tbpost = tbpostRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("No Data"));
        if(param.getTitle() != null){
            tbpost.setTitle(param.getTitle());
        }
        if(param.getContent() != null){
            tbpost.setContent(param.getContent());
        }
        tbpostRepository.save(tbpost);

        return tbpost.toUpdateResDto();
    }
}
