package com.board.boardprac.services;

import com.board.boardprac.beans.dao.BoardDAO;
import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.beans.vo.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public void register(BoardVO board) {
        boardDAO.register(board);
    }

    @Override
    public BoardVO get(Long bno) {
        return boardDAO.get(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        return boardDAO.modify(board);
    }

    @Override
    public boolean remove(Long bno) {
        return boardDAO.remove(bno);
    }

    @Override
    public List<BoardVO> getList() {
        return boardDAO.getList();
    }
    @Override
    public List<BoardVO> getList(Criteria cri) {
        return boardDAO.getList(cri);
    }

    @Override
    public int getTotal(Criteria cri) { return boardDAO.getTotal(cri); }
}
