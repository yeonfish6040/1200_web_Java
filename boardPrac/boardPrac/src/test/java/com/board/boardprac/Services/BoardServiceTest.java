package com.board.boardprac.Services;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.services.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class BoardServiceTest {

    @Autowired
    private BoardServiceImpl boardService;

    @Test
    @Disabled
    public void testRegister() {
        IntStream.rangeClosed(1, 400).forEach(i -> {
            BoardVO board = new BoardVO();
            board.setTitle("새글! - " + i);
            board.setContent("아 내용 뭐하지" + i);
            board.setWriter("Unknown author" + i);

            boardService.register(board);
            log.info("고유번호: "+board.getBno());
        });
    }

    @Test
    @Disabled
    public void testGet() {
        log.info(boardService.get(4L).toString());
    }
}
