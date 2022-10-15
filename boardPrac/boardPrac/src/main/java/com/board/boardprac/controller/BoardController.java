package com.board.boardprac.controller;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.services.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService service;

    @GetMapping("list")
    public String list(Model model) {
        log.info("----------------------------------------------");
        log.info("List called");
        log.info("----------------------------------------------");

        model.addAttribute("list", service.getList());

        return "hi";
    }

//    @GetMapping("register")
    public void register() {}

    @PostMapping("register")
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr) {
        log.info("----------------------------------------------");
        log.info("Register called: "+boardVO);
        log.info("----------------------------------------------");

        rttr.addFlashAttribute("bno", boardVO.getBno());

        return new RedirectView("list");
    }

    @RequestMapping({"get", "modify"})
    public void get(@RequestParam("bno") Long bno, HttpServletRequest req, Model model) {
        String reqURI = req.getRequestURI();
        String type = reqURI.replace("/board/", "");

        log.info("----------------------------------------------");
        log.info(type+" called, "+bno);
        log.info("----------------------------------------------");

        if (type == "get") {
            model.addAttribute("board", service.get(bno));
        } else if (type == "modify") {
            if (service.modify(board))
                rttr.addAttribute("result", "success");
            else
                rttr.addAttribute("result", "fail");
        }
    }

//    @GetMapping("get")
    public String get(@RequestParam("bno") Long bno, Model model) {
        log.info("----------------------------------------------");
        log.info("get called: "+bno);
        log.info("----------------------------------------------");

        model.addAttribute("board", service.get(bno));

        return model.toString();
    }

//    @PostMapping("modify")
    public RedirectView modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify: "+board);

        if (service.modify(board))
            rttr.addAttribute("result", "success");
        else
            rttr.addAttribute("result", "fail");

        return new RedirectView("list");
    }

    @PostMapping("remove")
    public RedirectView remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
        log.info("----------------------------------------------");
        log.info("remove called: "+bno);
        log.info("----------------------------------------------");

        if (service.remove(bno))
            rttr.addFlashAttribute("result", "success");
        else
            rttr.addFlashAttribute("result", "fail");

        return new RedirectView("list");
    }
}
