package com.example.board.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.beans.vo.BoardVO;

@Mapper
public interface BoardMapper {
	// 게시글 목록
	public List<BoardVO> getList();


	public void insert(BoardVO board);

	public void insertSelectKey_bno(BoardVO board);

	public BoardVO read(Long bno);
}
