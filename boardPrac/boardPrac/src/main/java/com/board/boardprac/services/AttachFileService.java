package com.board.boardprac.services;

import com.board.boardprac.beans.vo.AttachFileVO;
import com.board.boardprac.beans.vo.AttachReturnVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public interface AttachFileService {
    public AttachReturnVO upload(Long bno, String uploadFolder, MultipartFile mf) throws IOException;

    AttachReturnVO upload(Long bno, String uploadFolder, MultipartFile mf, boolean noSql) throws IOException;

    AttachReturnVO upload(String uploadFolder, MultipartFile mf) throws IOException;

    boolean upload(AttachFileVO attachFileVO) throws IOException;

    public boolean delete(String uuid);
    public List<AttachFileVO> getList(Long bno);
}
