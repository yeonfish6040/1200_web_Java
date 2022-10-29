package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/board/post*")
public class UploadController {

    private logger log = new logger();

    @GetMapping("/uploadForm")
    public void uploadForm() {
        log.title("upload form");
    }

    @PostMapping("/uploadAjaxAction")
    public String uploadAjaxPost(MultipartFile[] uploadFile) {
        String uploadFolder = "/Users/iyeonjun/Desktop";

        for (MultipartFile mf: uploadFile) {
            log.info("UploadFileName: "+mf.getOriginalFilename());
            log.info("UploadFileSize: "+mf.getSize());

            String uploadFileName = mf.getOriginalFilename();
            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1)+".uploadStuff";
            File saveFile = new File(uploadFolder, uploadFileName);
            try {
                mf.transferTo(saveFile);
            }catch (Exception e) {}
        }


        return "upload/upload";
    }
}
