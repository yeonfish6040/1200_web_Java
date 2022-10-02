package com.board.boardprac.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service // Spring Container에 Bean 등록
@Mapper // MyBatis 연결 등록
public interface TimeMapper {
    //@Select("select sysdate from dual")
    public String getTime();

}
