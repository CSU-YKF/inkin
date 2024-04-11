package cn.csu.ykf.inkin.core.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.reactive.function.client.WebClient;

import cn.csu.ykf.inkin.common.model.dto.assessment.AssessmentRequest;
import cn.csu.ykf.inkin.common.model.dto.assessment.AssessmentResponse;
import cn.csu.ykf.inkin.common.model.dto.info.GetInfoResponse;
import cn.csu.ykf.inkin.common.model.po.Assessment;

public class AlgorithmClient {

    public AssessmentResponse assess(AssessmentRequest request) {
        WebClient webClient = WebClient.create();

        Map<String, String> data = new HashMap<>();
        data.put("image_base64", request.getBase64Image());

        AssessmentResponse assessment = webClient.post()
            .uri("http://localhost:50051/evaluate")
            .bodyValue(data)
            .retrieve()
            .bodyToMono(AssessmentResponse.class)
            .block();
        return assessment;
    }

    public GetInfoResponse getInfo(String charName) {
        String url = "http://localhost:50051/get_info?char=" + charName;
        WebClient webClient = WebClient.create();
        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(GetInfoResponse.class)
            .block();
    }
}
