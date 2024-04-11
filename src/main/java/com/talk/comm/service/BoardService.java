package com.talk.comm.service;

import com.talk.comm.domain.Board;
import com.talk.comm.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
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
