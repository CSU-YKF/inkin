package cn.csu.ykf.inkin.common.model.dto.assessment;

import lombok.Data;

@Data
public class AssessmentResponse {

    private double score;
    private String comment;
    private String paraphrase;
    private String charName;
}
