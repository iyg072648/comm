package com.talk.comm.controller;

import com.talk.comm.dto.CommentDTO;
import com.talk.comm.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/save")
    public String save(){
        return "save";
    }

    @PostMapping("/comment/save")
    public String save(CommentDTO commentDTO) throws IOException{
        System.out.println("commentDTO = " + commentDTO);
        commentService.save(commentDTO);
        return "redirect:/board/list";
    }

}
