package cn.csu.ykf.inkin.common.model.dto.upload;

import lombok.Data;

@Data
public class UploadResponse {

    private Long ImageId;
    private String comment;
    private String paraphrase;
}
