package com.board.boardprac.beans.dao;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.vo.AttachFileVO;
import com.board.boardprac.mappers.AttachFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachFileDAO {

    @Autowired
    private AttachFileMapper mapper;

    public boolean upload(AttachFileVO attachFileVO) { return mapper.insert(attachFileVO) != 0; }

    public boolean delete(String uuid) { return mapper.delete(uuid) != 0; }

    public List<AttachFileVO> getList(Long bno) { return mapper.getList(bno); }
}
