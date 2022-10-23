package com.board.boardprac.beans;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.dao.ReplyDAO;
import com.board.boardprac.beans.vo.ReplyVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyDAOTest{

    @Autowired
    ReplyDAO replyDAO;
    private logger log = new logger();

    private Long[] arBno = {721L, 720L, 219L, 218L, 217L};

    @Test
    @Disabled
    public void testReplyDAO() {
        log.info(replyDAO.toString());
    }

    @Test
//    @Disabled
    public void testInsert() {
        IntStream.rangeClosed(1, 15).forEach(i -> {
            ReplyVO replyVO = new ReplyVO();

            replyVO.setBno(arBno[i % 5]);
            replyVO.setReply("댓글 테스트 - DAO - " + i);
            replyVO.setReplier("guest"+i);

            log.info(replyDAO.register(replyVO));
        });
    }

    @Test
    @Disabled
    public void testRead() {
        Long targetRno = 5L;
        ReplyVO replyVO = replyDAO.get(targetRno);
        log.info(replyVO);
    }
}
