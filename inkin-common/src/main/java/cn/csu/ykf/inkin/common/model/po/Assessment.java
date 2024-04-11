package cn.csu.ykf.inkin.common.model.po;

//import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("assessment")
public class Assessment {
    private Long id;
    private Long userId;
    private Long imageId;
    private double score;
    private String comment;
    private String characterName;
    private String paraphrase;
}
