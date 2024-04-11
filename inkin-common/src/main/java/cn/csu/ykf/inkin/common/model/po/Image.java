package cn.csu.ykf.inkin.common.model.po;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("image")
public class Image {

    private Long id;
    private String base64Image;
}
