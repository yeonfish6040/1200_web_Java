package com.board.boardprac.services;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.beans.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public void register(BoardVO board);
    public BoardVO get(Long bno);
    public boolean modify(BoardVO board);
    public boolean remove(Long bno);
    public List<BoardVO> getList();
    public List<BoardVO> getList(Criteria cri);
    public int getTotal(Criteria cri);
}
