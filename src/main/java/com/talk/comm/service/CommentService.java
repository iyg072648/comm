package com.talk.comm.service;

import com.talk.comm.domain.comment.CommentRequest;
import com.talk.comm.domain.comment.CommentResponse;
import com.talk.comm.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


//    저장
//    params - 댓글 정보
//    return pk
    @Transactional
    public Long saveComment(final CommentRequest params){
        commentRepository.save(params);
        return params.getId();
    }

//    댓글 상세정보 조회,
//    params id - pk
//    return - 댓글 상세정보
    public CommentResponse findCommentById(final Long id){
        return commentRepository.findById(id);
    }

//    댓글수정
//    params - 댓글정보
//    return pk
    @Transactional
    public Long updateComment(final CommentRequest params){
        commentRepository.update(params);
        return params.getId();
    }

//    댓글삭제
//    params - pk
//    return pk
    @Transactional
    public Long deleteComment(final Long id){
        commentRepository.deleteById(id);
        return id;
    }

//    댓글 리스트 조회
//    params boardId - 게시글 번호(fk)
//    return 특정게시글에 등록된 댓글 리스트
    public List<CommentResponse> findAllComment(final Long boardId){
        return commentRepository.findAll(boardId);
    }
}
