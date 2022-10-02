package com.board.boardprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication // (exclude= {DataSourceAutoConfiguration.class})
public class BoardPracApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoardPracApplication.class, args);
    }
}
