package com.talk.comm.domain.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequest {
    private Long id;
    private Long boardId;
    private String content;
    private String writer;
}
