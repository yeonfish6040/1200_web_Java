package com.board.boardprac.controller;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.dto.pageDTO;
import com.board.boardprac.services.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService service;

    @GetMapping("list")
    public String list(Criteria cri, Model model) {
        log.info("----------------------------------------------");
        log.info("List called");
        log.info("----------------------------------------------");

        if (model.getAttribute("page") != null) {
            cri = new Criteria(Integer.valueOf(model.getAttribute("page").toString()));
        }

        model.addAttribute("list", service.getList(cri));
        model.addAttribute("pageMaker", new pageDTO(cri, service.getTotal()));

        return "thymeleaf/board/list";
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

    @GetMapping({"get", "modify"})
    public String get(@RequestParam("bno") Long bno, HttpServletRequest req, Model model) {
        String reqURI = req.getRequestURI();
        String type = reqURI.replace("/board/", "");

        log.info("----------------------------------------------");
        log.info(type+" called, "+bno);
        log.info("----------------------------------------------");

        model.addAttribute("board", service.get(bno));
        return "thymeleaf/board/get";
    }

    @PostMapping("get")
    public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("----------------------------------------------");
        log.info("get called: "+bno);
        log.info("----------------------------------------------");

        model.addAttribute("board", service.get(bno));
    }

    @PostMapping("modify")
    public RedirectView modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify: "+board);

        if (service.modify(board)) {
            rttr.addAttribute("result", "success");
            rttr.addAttribute("board", service.get(board.getBno()));
        }else
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


    @GetMapping("{page}")
    public RedirectView listPaging(@PathVariable("page") int page, RedirectAttributes rttr) {
        rttr.addFlashAttribute("page", page);
        return new RedirectView("./list");
    }
}
