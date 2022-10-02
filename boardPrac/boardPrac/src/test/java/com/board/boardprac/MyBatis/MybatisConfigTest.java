package com.board.boardprac.MyBatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class MybatisConfigTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() {
        try (Connection conn = dataSource.getConnection();) {
            log.info("----------------------------------");
            log.info("datasource connection: "+conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
