package com.talk.comm.repository;

import com.talk.comm.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final SqlSessionTemplate sql;

    public CommentDTO save(CommentDTO commentDTO){
        sql.insert("Comment.save", commentDTO);
        return commentDTO;
    }

    public List<CommentDTO> findAll(){
        return sql.selectList("Comment.findAll");
    }

    public CommentDTO findById(Long id){
        return sql.selectOne("Comment.findById", id);
    }

}
