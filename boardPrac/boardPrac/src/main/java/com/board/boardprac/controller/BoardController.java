package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.dto.PageDTO;
import com.board.boardprac.services.AttachFileServiceImpl;
import com.board.boardprac.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private logger log = new logger();
    private final BoardService service;

    private final AttachFileServiceImpl attachFileService;

    @GetMapping("/list")
    public String list(Criteria cri, Model model) {
        log.info("----------------------------------------------");
        log.info("List called");
        log.info("----------------------------------------------");

//        if (model.getAttribute("page") != null) {
//            cri = new Criteria(Integer.valueOf(model.getAttribute("page").toString()));
//        }

        model.addAttribute("list", service.getList(cri));
        model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));


        return "board/list";
    }

    @GetMapping("/register")
    public String register() {
        return "board/register";
    }
    
    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr) {
        log.info("----------------------------------------------");
        log.info("Register called: "+boardVO);
        log.info("----------------------------------------------");

        service.register(boardVO);

        if (boardVO.getAttachFileVOList() != null) {
            log.title("not null");
            boardVO.getAttachFileVOList().forEach(attach -> {
                try {
                    attach.setBno(boardVO.getBno());
                    log.info("upload success: "+attachFileService.upload(attach)+" | "+attach.toString());
                } catch (Exception e) {
                    log.error(e);
                }
            });
        }

        rttr.addFlashAttribute("bno", boardVO.getBno());

        return new RedirectView("list");
    }

    @GetMapping({"/get"})
    public String get(@RequestParam("bno") Long bno, HttpServletRequest req, Model model) {
        String reqURI = req.getRequestURI();
        String type = reqURI.replace("/board/", "");

        log.info("----------------------------------------------");
        log.info(type+" called, "+bno);
        log.info("----------------------------------------------");

        model.addAttribute("board", service.get(bno));
        return "board/get";
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam long bno) {
        service.remove(bno);

        return new RedirectView("list");
    }

    @PostMapping("/get")
    public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("----------------------------------------------");
        log.info("get called: "+bno);
        log.info("----------------------------------------------");

        model.addAttribute("board", service.get(bno));
    }

    @PostMapping("/modify")
    public RedirectView modify(BoardVO board, RedirectAttributes rttr) {

        if (service.modify(board)) {
            rttr.addAttribute("result", "success");
            rttr.addAttribute("board", service.get(board.getBno()).toString());
        }else {
            rttr.addAttribute("result", "fail");
        }

        return new RedirectView("list");
    }

    @PostMapping("/remove")
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


    // paging
//    @GetMapping("/{page:[0-9]*}")
    public RedirectView listPaging(@PathVariable("page") int page, RedirectAttributes rttr) {
        rttr.addFlashAttribute("page", page);
        return new RedirectView("./list");
    }

    // main redirect
    @GetMapping("")
    public RedirectView mainView() {
        return new RedirectView("/board/list");
    }
}
