package com.example.scsmrgwang.dto;

import com.example.scsmrgwang.domain.Tbpost;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class TbpostDto {

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto{

        @Schema(description = "id", example = "")
        @NotNull
        @NotEmpty
        @Size(max = 100)
        private String title;

        @Schema(description = "author", example="")
        @NotNull
        @NotEmpty
        @Size(max=30)
        private String author;

        @Schema(description = "content", example="")
        @Size(max=5000)
        private String content;

        public Tbpost toEntity(){
            return Tbpost.of(title, author, content);
        }
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateResDto{
        private String id;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailReqDto{
        private String id;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResDto{
        private String id;
        private String deleted;
        private String process;
        private String createAt;
        private String modifiedAt;

        private String title;
        private String author;
        private String content;
    }
}
