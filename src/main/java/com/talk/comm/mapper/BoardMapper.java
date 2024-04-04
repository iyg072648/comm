package com.talk.comm.mapper;

import com.talk.comm.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {

    public int boardCount();

    public List<Board> getList();

}
