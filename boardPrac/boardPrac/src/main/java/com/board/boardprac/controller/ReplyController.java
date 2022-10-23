package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.beans.vo.ReplyVO;
import com.board.boardprac.services.ReplyService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RequestMapping("/reply*")
@RestController() // view Resolver
public class ReplyController {
    private logger log = new logger();

    @Autowired
    private ReplyService replyService;

    /*
    * 댓글 등록
    * 브라우저에서 JSON타입으로 데이터를 전송하고
    * 서버에서는 댓글의 처리 결과에 따라 문자열로  결과 전송
    * consumes: Ajax를 통해 전달받은 데이터의 타입
    * produces: Ajax의 success:function(result)에 있는 result로 전송할 데이터의 타입
    * @ResponseBody: @Controller에서 Body를 응탑하기 위해 (viewResolver를 가지 않기 위해)
    * ResponseEntity: 서버의 상태코드, 응답 메시지등을 담을 수 있는 타입 @RequestBody를 사용하여 JSON 데이터를 ReplyVO 형태로 변환하도록 지정
     */

    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException {
        boolean insertOk = false;

        log.info("ReplyVO: "+replyVO);

        insertOk = replyService.register(replyVO);

        if (insertOk) {
            return new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "utf-8"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 전체 조회
    @GetMapping("/pages/{bno:[0-9]*}/{page:[0-9]*}")
    public List<ReplyVO> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page) {
        log.title("reply - list");
        return replyService.getList(new Criteria(page), bno);
    }

    // 댓글 조회
    @GetMapping("/{rno:[0-9]*}")
    public ReplyVO get(@PathVariable("rno") Long rno) {
        log.title("get");
        return replyService.get(rno);
    }

    @PatchMapping(value = "/{rno:[0-9]*}", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> modify(@RequestBody ReplyVO replyVO, @PathVariable(value = "replier", required = false) String replier, @PathVariable("rno") Long rno) throws UnsupportedEncodingException {
        replyVO.setRno(rno);

        log.info("rno: "+rno);
        log.info("modify: "+replyVO);

        if (replyVO.getReplier() == null) {
            replyVO.setReplier("anonymous");
        }

        if (replyService.modify(replyVO)) {
            return new ResponseEntity<>(new String("댓글 수정 성공".getBytes(), "utf-8"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{rno:[0-9]*}", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) throws UnsupportedEncodingException {
        log.title("remove: "+rno);
        if (replyService.remove(rno)) {
            return new ResponseEntity<>(new String("댓글 삭제 성공".getBytes(), "utf-8"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
