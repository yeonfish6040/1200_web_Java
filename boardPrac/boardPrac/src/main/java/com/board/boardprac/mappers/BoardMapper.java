package com.board.boardprac.mappers;

import java.util.List;

import com.board.boardprac.beans.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import com.board.boardprac.beans.vo.BoardVO;
import org.springframework.stereotype.Service;

@Mapper
public interface BoardMapper {
	// 게시글 목록
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board);

	public void insertSelectKey_bno(BoardVO board);

	public BoardVO read(Long bno);

	/** return: affected row count */
	public int delete(Long bno);

	public int update(BoardVO board);

	public int getTotal();
}
