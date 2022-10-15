package com.board.boardprac.beans;

import com.board.boardprac.beans.dao.BoardDAO;
import com.board.boardprac.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;


//    @Disabled
//    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("오늘의 새소식");
        board.setTitle("아무제목");
        board.setWriter("나 관리자야");
        boardDAO.register(board);
        log.info("생성된 게시물 고유번호: "+board.getBno());
    }
//    @Disabled
    @Test
    public void testGet() {
        log.info(boardDAO.get(4L).toString());
    }

//    @Test
    public void tesetGetList() {
        boardDAO.getList().forEach((board) -> {
            log.info(board.toString());
        });
    }

//    @Test
    public void testModify() { // 1L 수정 테스트
        BoardVO board = new BoardVO();
        board.setTitle("제목수정");
        board.setContent("새로운 내용이다");
        board.setWriter("나나나나나");
        board.setBno(1L);

        log.info("Modify: "+boardDAO.modify(board));
    }
}
