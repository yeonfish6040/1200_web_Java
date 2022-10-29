package com.board.boardprac.mappers;

import com.board.boardprac.beans.vo.AttachFileVO;

import java.util.List;

public interface AttachFileMapper {
    public void insert(AttachFileVO attachFileVO);
    public void delete(String uuid);
    public List<AttachFileVO> getList(Long bno);
}
