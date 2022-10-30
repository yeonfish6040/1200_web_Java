package com.board.boardprac.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AttachFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private String originalName;
    private boolean image;
    private Long bno;
}
