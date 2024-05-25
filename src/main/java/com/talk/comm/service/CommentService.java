package com.talk.comm.service;

import com.talk.comm.dto.CommentDTO;
import com.talk.comm.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    public void save(CommentDTO commentDTO) throws IOException{
        commentRepository.save(commentDTO);
    }

    public List<CommentDTO> findAll(){
        return commentRepository.findAll();
    }

    public CommentDTO findById(Long id){
        return commentRepository.findById(id);
    }

}
