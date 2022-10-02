package com.board.boardprac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service // Spring Container에 Bean 등록
@Mapper // MyBatis 연결 등록
public interface TimeMapper {
    public String getTime();

}
