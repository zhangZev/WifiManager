package com.wanzhong.data.po;

import com.wanzhong.common.po.BasePo;

public class FileUploadRespPo extends BasePo {

    private String fileId;

    private String fileName;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
