package com.talk.comm.service;

import com.talk.comm.domain.Board;
import com.talk.comm.dto.BoardDTO;
import com.talk.comm.mapper.BoardMapper;
import com.talk.comm.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    private final BoardMapper boardMapper;

    public void save(BoardDTO boardDTO){
        boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll(){
        return boardRepository.findAll();
    }

    public int boardCount() {
        return boardMapper.boardCount();
    }

    public List<Board> BoardList() {
        return boardMapper.getList();
    }

    public Board getBoard(int boardId){
        return boardMapper.getBoard(boardId);
    }

}
