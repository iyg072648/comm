package com.talk.comm.controller;

import com.talk.comm.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String tset(Model model) {

        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.BoardList());

        return "boards/index";
    }
}
