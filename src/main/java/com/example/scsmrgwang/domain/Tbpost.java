package com.example.scsmrgwang.domain;

import com.example.scsmrgwang.dto.TbpostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table(indexes = {
        @Index(columnList = "deleted"),
        @Index(columnList = "process"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "modifiedAt")
})
@Entity
public class Tbpost extends AuditingFields{

    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String author;
    @Setter @Column(nullable = true) @Lob private String content;

    //protected와 private로 막아서 of로만 생성
    protected Tbpost() {}
    private Tbpost(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
    public static Tbpost of(String title, String author, String content) {
        return new Tbpost(title, author, content);
    }

    public TbpostDto.CreateResDto toCreateResDto() {
        /* 첫번째 방법
        TbpostDto.CreateResDto createResDto = new TbpostDto.CreateResDto();
        createResDto.setId(this.getId());

        return createResDto;*/

        //두번째 방법( build를 이용하여 한줄로 return)
        return TbpostDto.CreateResDto.builder().id(this.getId()).build();
    }

    public TbpostDto.UpdateResDto toUpdateResDto() {
        return TbpostDto.UpdateResDto.builder().id(this.getId()).build();
    }
}
