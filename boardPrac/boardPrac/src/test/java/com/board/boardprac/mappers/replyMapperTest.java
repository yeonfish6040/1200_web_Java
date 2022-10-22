package com.board.boardprac.mappers;

import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.beans.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class replyMapperTest {

    @Autowired
    private ReplyMapper mapper;

    @Test
    @Disabled
    public void testMapper() {
        log.info(mapper.toString());
    }

    private Long[] arBno = {295L, 294L, 293L, 292L, 290L};

    @Test
    @Disabled
    public void testInsert() {
        IntStream.rangeClosed(11, 100).forEach(i -> {
            ReplyVO reply = new ReplyVO();

            reply.setBno(arBno[i%5]);
            reply.setReply("a");
            reply.setReplier("뭐");

            mapper.insert(reply);
        });
    }

    @Test
    @Disabled
    public void testRead() {
        Long targetRno = 4L;

        ReplyVO replyVO = mapper.read(targetRno);
        log.info(replyVO.toString());
    }

    @Test
    @Disabled
    public void testDelete() {
        Long targetRno = 8L;
        mapper.delete(targetRno);
    }

    @Test
    @Disabled
    public void testUpdate() {
        Long targetrno = 5L;

        ReplyVO reply = mapper.read(targetrno);
        if (reply != null) {
            reply.setReply("updateOk");

            int count = mapper.update(reply);
            log.info(String.valueOf(count));
        }
    }

    @Test
//    @Disabled
    public void testPaging() {
        Criteria cri = new Criteria(1);

        List<ReplyVO> replies = mapper.getListWithPaging(cri, 290L);

        replies.forEach(e -> log.info(e.toString()));
    }
}
