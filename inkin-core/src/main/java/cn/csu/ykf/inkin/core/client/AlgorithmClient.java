package cn.csu.ykf.inkin.core.client;

import org.springframework.web.reactive.function.client.WebClient;

import cn.csu.ykf.inkin.common.model.dto.assessment.AssessmentRequest;
import cn.csu.ykf.inkin.common.model.dto.assessment.AssessmentResponse;

public class AlgorithmClient {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create();
//        User user = new User("username", "password");
        String result = webClient.post()
            .uri("http://example.com")
//            .bodyValue(user)
            .retrieve()
            .bodyToMono(String.class)
            .block();
        System.out.println(result);
    }

    public AssessmentResponse assess(AssessmentRequest request){
        return null;
    }
}
