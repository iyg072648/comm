package com.talk.comm.controller;

import com.talk.comm.domain.comment.CommentRequest;
import com.talk.comm.domain.comment.CommentResponse;
import com.talk.comm.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //신규 댓글 생성
    @PostMapping("/board/{id}/comments")
    public CommentResponse saveComment(@PathVariable final Long boardId, @RequestBody final CommentRequest params){
        Long id = commentService.saveComment(params);
        return commentService.findCommentById(id);
    }
}
