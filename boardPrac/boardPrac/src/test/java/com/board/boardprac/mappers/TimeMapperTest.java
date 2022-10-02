package com.board.boardprac.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TimeMapperTest {
    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        String sysdate = timeMapper.getTime();
        log.info("----------------------------------");
        log.info("Sysdate: "+sysdate);
        log.info("----------------------------------");
    }
}
