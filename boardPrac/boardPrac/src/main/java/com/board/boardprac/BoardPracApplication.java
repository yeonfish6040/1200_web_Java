package com.board.boardprac;

import com.board.boardprac.mappers.BoardMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //(exclude= {DataSourceAutoConfiguration.class})
public class BoardPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardPracApplication.class, args);
	}

}
