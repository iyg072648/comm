package com.talk.comm.controller;

import com.talk.comm.dto.BoardDTO;
import com.talk.comm.dto.BoardFileDTO;
import com.talk.comm.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO) throws IOException {
        System.out.println("boardDTO = " + boardDTO);
        service.save(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = service.findAll();
        model.addAttribute("boardList", boardDTOList);
//        System.out.println("boardDTOList = " + boardDTOList);
        return "list";
    }

    @GetMapping("{id}")
    public String findyById(@PathVariable("id")Long id, Model model){
        // 조회수 처리
        service.updateHits(id);

        //상세내용 가져옴
        BoardDTO boardDTO = service.findById(id);
        model.addAttribute("board", boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        if (boardDTO.getFileAttached() == 1){
            List<BoardFileDTO> boardFileDTOList = service.findFile(id);
            model.addAttribute("boardFileList", boardFileDTOList);
        }
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable ("id") Long id, Model model){
        BoardDTO boardDTO = service.findById(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO, Model model){
        service.update(boardDTO);
        BoardDTO dto = service.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/board/list";
    }

}
