package com.talk.comm.domain.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

    private Long id;
    private Long boardId;
    private String content;
    private String writer;
    private Boolean deleteYn;
    private LocalDateTime create_date;
    private LocalDateTime modified_date;

}
