package com.talk.comm.service;

import com.talk.comm.domain.Board;
import com.talk.comm.dto.BoardDTO;
import com.talk.comm.dto.BoardFileDTO;
import com.talk.comm.mapper.BoardMapper;
import com.talk.comm.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public void save(BoardDTO boardDTO) throws IOException {
        if (boardDTO.getBoardFile().get(0).isEmpty()){
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        } else {
            // 파일이 있다.
            boardDTO.setFileAttached(1);
            // 게시판 저장 후 id값 활용을 위해 리턴 받음.
            BoardDTO savedBoard = boardRepository.save(boardDTO);
            //파일만 따로 가져오기
            for (MultipartFile boardFile: boardDTO.getBoardFile()) {
                // 파일 이름 가져오기
                String originalFilename = boardFile.getOriginalFilename();
                System.out.println("originalFilename = " + originalFilename);
                // 저장용 이름 만들기
                System.out.println(System.currentTimeMillis());
                String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
                System.out.println("storedFileName = " + storedFileName);

                //BoardFileDTO 세팅
                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginalFileName(originalFilename);
                boardFileDTO.setStoredFileName(storedFileName);
                boardFileDTO.setBoardId(savedBoard.getId());

                //파일 저장용 폴더에 파일 저장 처리
                String savePath = "C:/development/" + storedFileName;
                boardFile.transferTo(new File(savePath));
                // board_file_table 저장 처리
                boardRepository.saveFile(boardFileDTO);
            }
        }
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

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public List<BoardFileDTO> findFile(Long id) {
        return boardRepository.findFile(id);
    }
}
