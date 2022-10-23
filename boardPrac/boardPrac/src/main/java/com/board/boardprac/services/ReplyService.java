package com.board.boardprac.services;

import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.beans.vo.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    public boolean register(ReplyVO replyVO);
    public ReplyVO get(Long rno);
    public boolean modify(ReplyVO replyVO);
    public boolean remove(Long rno);
    public List<ReplyVO> getList(Criteria cri, Long bno);
}
