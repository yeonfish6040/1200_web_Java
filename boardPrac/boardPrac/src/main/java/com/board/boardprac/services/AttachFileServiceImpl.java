package com.board.boardprac.services;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.dao.AttachFileDAO;
import com.board.boardprac.beans.vo.AttachFileVO;
import com.board.boardprac.beans.vo.AttachReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class AttachFileServiceImpl implements AttachFileService {

    private logger log = new logger();

    @Autowired
    private AttachFileDAO attachFileDAO;

    @Override
    public AttachReturnVO upload(Long bno, String uploadFolder, MultipartFile mf) throws IOException {
//        log.title("upload");
        String uploadFileName = mf.getOriginalFilename();
        String originFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        uploadFileName = uuid+"."+uploadFileName.split("[.]")[uploadFileName.split("[.]").length-1]+"";
        File saveFile = new File(uploadFolder, uploadFileName);
        mf.transferTo(saveFile);

        AttachFileVO attachFileVO = new AttachFileVO();
        attachFileVO.setFileName(uploadFileName);
        attachFileVO.setOriginalName(originFileName);
        attachFileVO.setUuid(uuid);
        attachFileVO.setBno(bno);
        attachFileVO.setImage(checkImageType(saveFile));
        attachFileVO.setUploadPath(uploadFolder);
        attachFileDAO.upload(attachFileVO);
        return new AttachReturnVO(attachFileVO, saveFile);
    }

    @Override
    public AttachReturnVO upload(Long bno, String uploadFolder, MultipartFile mf, boolean noSql) throws IOException {
        if (noSql) {
            String uploadFileName = mf.getOriginalFilename();
            String originFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
            uploadFileName = uuid+"."+uploadFileName.split("[.]")[uploadFileName.split("[.]").length-1]+"";
            File saveFile = new File(uploadFolder, uploadFileName);
            mf.transferTo(saveFile);

            AttachFileVO attachFileVO = new AttachFileVO();
            attachFileVO.setFileName(uploadFileName);
            attachFileVO.setOriginalName(originFileName);
            attachFileVO.setUuid(uuid);
            attachFileVO.setBno(bno);
            attachFileVO.setImage(checkImageType(saveFile));
            attachFileVO.setUploadPath(uploadFolder);
            return new AttachReturnVO(attachFileVO, saveFile);
        }else {
            return upload(bno, uploadFolder, mf);
        }
    }

    @Override
    public AttachReturnVO upload(String uploadFolder, MultipartFile mf) throws IOException {
        String uploadFileName = mf.getOriginalFilename();
        String originFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        uploadFileName = uuid+"."+uploadFileName.split("[.]")[uploadFileName.split("[.]").length-1]+"";
        File saveFile = new File(uploadFolder, uploadFileName);
        mf.transferTo(saveFile);
        AttachFileVO attachFileVO = new AttachFileVO();
        attachFileVO.setFileName(uploadFileName);
        attachFileVO.setOriginalName(originFileName);
        attachFileVO.setUuid(uuid);
        attachFileVO.setImage(checkImageType(saveFile));
        attachFileVO.setUploadPath(uploadFolder);
        return new AttachReturnVO(attachFileVO, saveFile);
    }

    @Override
    public boolean upload(AttachFileVO attachFileVO) throws IOException {
        return attachFileDAO.upload(attachFileVO);
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }

    @Override
    public List<AttachFileVO> getList(Long bno) {
        return null;
    }

    private boolean checkImageType(File file) {
        String mimetype= new MimetypesFileTypeMap().getContentType(file);
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
            return true;
        else
            return false;
    }
}
