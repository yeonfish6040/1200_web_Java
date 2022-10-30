package com.board.boardprac.mappers;

import com.board.boardprac.beans.vo.AttachFileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface AttachFileMapper {
    public int insert(AttachFileVO attachFileVO);
    public int delete(String uuid);
    public List<AttachFileVO> getList(Long bno);
}
