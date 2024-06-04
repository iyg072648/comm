package com.talk.comm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDTO {

    private Long id;
    private Long boardId;
    private String commentWriter;
    private String commentContents;
    private String createdAt;
    private Boolean deleteYn;

}
