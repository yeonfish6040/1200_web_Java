package com.board.boardprac.mappers;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.beans.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    public int insert(ReplyVO replyVO);
    public ReplyVO read(Long rno);
    public int delete(Long rno);

    public int update(ReplyVO replyVO);

    public List<ReplyVO> getListWithPaging(@Param("cri") Criteria criteria, @Param("bno") Long bno);

}
