package com.board.boardprac.beans.dao;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.vo.Criteria;
import com.board.boardprac.beans.vo.ReplyVO;
import com.board.boardprac.mappers.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {

    @Autowired
    private ReplyMapper mapper;

    private logger log = new logger();

    public boolean register(ReplyVO replyVO) { return mapper.insert(replyVO) != 0; }
    public ReplyVO get(Long rno) {
        return mapper.read(rno);
    }
    public boolean modify(ReplyVO replyVO){
        return mapper.update(replyVO) != 0;
    }
    public boolean remove(Long rno){
        return mapper.delete(rno) != 0;
    }
    public List<ReplyVO> getList(Criteria cri, Long bno){ return mapper.getListWithPaging(cri, bno); }
}
