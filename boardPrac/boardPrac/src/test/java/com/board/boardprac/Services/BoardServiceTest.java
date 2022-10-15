package com.board.boardprac.Services;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.services.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardServiceTest {

    @Autowired
    private BoardServiceImpl boardService;

    @Test
    @Disabled
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("새글!");
        board.setContent("아 내용 뭐하지");
        board.setWriter("Unknown author");

        boardService.register(board);
        log.info("고유번호: "+board.getBno());
    }

    @Test
    public void testGet() {
        log.info(boardService.get(4L).toString());
    }
}
