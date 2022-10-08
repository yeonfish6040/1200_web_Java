package com.board.boardprac.beans.DAO;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private BoardMapper mapper;

    public void register(BoardVO board) {
        mapper.insertSelectKey_bno(board);
    }

    public BoardVO get(Long bno) {
        return mapper.read(bno);
    }

    public boolean modify(BoardVO board) {
        return mapper.update(board) != 0;
    }

    public boolean remove(Long bno) {
        return mapper.delete(bno) != 0;
    }

    public List<BoardVO> getList() {
        return mapper.getList();
    }
}
