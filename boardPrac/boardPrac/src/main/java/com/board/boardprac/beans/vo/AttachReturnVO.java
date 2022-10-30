package com.board.boardprac.beans.vo;

import java.io.File;

public class AttachReturnVO {
    private AttachFileVO attachFileVO;
    private File saveFile;

    public AttachReturnVO(AttachFileVO attachFileVO, File saveFile) {
        this.attachFileVO = attachFileVO;
        this.saveFile = saveFile;
    }

    public AttachFileVO getAttachFileVO() {
        return attachFileVO;
    }

    public File getSaveFile() { return saveFile; }
}
