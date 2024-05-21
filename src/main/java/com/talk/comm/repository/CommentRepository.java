package com.talk.comm.repository;

import com.talk.comm.domain.comment.CommentRequest;
import com.talk.comm.domain.comment.CommentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {

    void save(CommentRequest params);

    CommentResponse findById(Long id);

    void update(CommentRequest params);

    void deleteById(Long id);

    List<CommentResponse> findAll(Long boardId);

    int count(Long boardId);
}
