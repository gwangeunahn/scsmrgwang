package com.example.smsprgwang.dto;

import com.example.smsprgwang.domain.Tbpost;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

public class TbpostDto {

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto{

        @Schema(description = "title", example = "")
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

        @Schema(description = "id", example = "")
        private String id;

    }



    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateReqDto{

        @Schema(description = "id", example = "")
        @NotNull
        @NotEmpty
        private String id;

        @Schema(description = "title", example = "")
        @Size(max = 100)
        private String title;

        @Schema(description = "content", example="")
        @Size(max=5000)
        private String content;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateResDto{

        @Schema(description = "id", example = "")
        private String id;

    }



    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailReqDto{

        @Schema(description = "id", example = "")
        private String id;

    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResDto{

        @Schema(description = "id", example = "")
        private String id;

        @Schema(description = "deleted", example = "")
        private String deleted;

        @Schema(description = "process", example = "")
        private String process;

        @Schema(description = "createdAt", example = "")
        private String createdAt;

        @Schema(description = "modifiedAt", example = "")
        private String modifiedAt;

        @Schema(description = "title", example = "")
        private String title;

        @Schema(description = "author", example = "")
        private String author;

        @Schema(description = "content", example = "")
        private String content;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListReqDto{

        @Schema(description = "deleted", example="")
        private String deleted;

        @Schema(description = "title", example = "")
        private String title;

        @Schema(description = "content", example="")
        private String author;

    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagedListReqDto{

        @Schema(description = "deleted", example="")
        private String deleted;
        @Schema(description = "title", example="")
        private String title;
        @Schema(description = "author", example="")
        private String author;

        @Schema(description = "orderby", example="")
        private String orderby;
        @Schema(description = "orderway", example="")
        private String orderway;
        @Schema(description = "offset", example="")
        private Integer offset;
        @Schema(description = "perpage", example="")
        private Integer perpage;
        @Schema(description = "callpage", example="")
        private Integer callpage;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagedListResDto{

        private Integer callpage;
        private Integer perpage;
        private String orderby;
        private String orderway;
        private Integer listsize;
        private Integer pagesize;
        private List<DetailResDto> list;
    }


}
