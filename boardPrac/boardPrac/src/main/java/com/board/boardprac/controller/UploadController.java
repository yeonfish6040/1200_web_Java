package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.beans.vo.AttachFileVO;
import com.board.boardprac.beans.vo.AttachReturnVO;
import com.board.boardprac.services.AttachFileService;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/board/post*")
public class UploadController {

    private logger log = new logger();

    @Autowired
    private AttachFileService attachFileService;

    @GetMapping("/uploadForm")
    public void uploadForm() {
        log.title("upload form");
    }

    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@RequestParam("filename") String fileName) {
        log.info("fileName: "+fileName);

        File file = new File("/Users/iyeonjun/Desktop/upload/"+fileName);
        log.info("file: "+file);

        ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders header = new HttpHeaders();
            header.add("Content-type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        }catch (Exception e) {
            StringBuffer err = new StringBuffer();
            err.append("\n==================================ERROR OCCURRED==================================\n");
            err.append("Reason: "+e.getMessage()+"\n");
            Arrays.stream(e.getStackTrace()).toList().forEach((er) -> {
                err.append(er+"\n");
            });
            err.append("==================================ERROR OCCURRED==================================");
            log.error(err.toString());
        }

        return result;
    }

    @ResponseBody
    @PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AttachFileVO> uploadAjaxPost(MultipartFile[] uploadFile) throws IOException {
        String uploadFolder = "/Users/iyeonjun/Desktop/upload";
//        String uploadFolder = ".";
        List<AttachFileVO> fileList = new ArrayList<AttachFileVO>();

        for (MultipartFile mf: uploadFile) {
            log.info("UploadFileName: "+mf.getOriginalFilename());
            log.info("UploadFileSize: "+mf.getSize());

            AttachReturnVO attachReturn = attachFileService.upload(uploadFolder, mf);
            InputStream in = new FileInputStream(attachReturn.getSaveFile());
            if (attachReturn.getAttachFileVO().isImage()) {
                FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder, "thumbnail_"+attachReturn.getAttachFileVO().getOriginalName()));
                Thumbnailator.createThumbnail(in, thumbnail, 100, 100);
            }
            fileList.add(attachReturn.getAttachFileVO());

        }


        return fileList;
    }
}
