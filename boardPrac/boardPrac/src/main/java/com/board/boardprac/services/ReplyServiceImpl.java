package com.board.boardprac.services;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.dao.ReplyDAO;
import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.beans.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private logger log = new logger();

    @Autowired
    private final ReplyDAO mapper;

    @Override
    public boolean register(ReplyVO replyVO) {
        return mapper.register(replyVO);
    }

    @Override
    public ReplyVO get(Long rno) {
        return mapper.get(rno);
    }

    @Override
    public boolean modify(ReplyVO replyVO) {
        return mapper.modify(replyVO);
    }

    @Override
    public boolean remove(Long rno) {
        return mapper.remove(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        return mapper.getList(cri, bno);
    }
}
