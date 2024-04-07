package cn.csu.ykf.inkin.common.model.po;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("assessment")
public class Assessment {
    private int id;
    private int userId;
    private String imageData;
    private double score;
    private String comment;
    private String characterName;
    private String paraphrase;
}
