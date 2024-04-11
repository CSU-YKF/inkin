package cn.csu.ykf.inkin.console.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.csu.ykf.inkin.common.model.dto.assessment.AssessmentRequest;
import cn.csu.ykf.inkin.common.model.dto.assessment.AssessmentResponse;
import cn.csu.ykf.inkin.common.model.dto.info.GetInfoResponse;
import cn.csu.ykf.inkin.common.model.po.Assessment;
import cn.csu.ykf.inkin.console.dao.AssessDao;
import cn.csu.ykf.inkin.console.dao.image.ImageDao;
import cn.csu.ykf.inkin.console.dao.user.UserDao;
import cn.csu.ykf.inkin.core.client.AlgorithmClient;

@Service
public class AssessService {

    @Autowired
    private AssessDao assessDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private UserDao userDao;

    private final AlgorithmClient client = new AlgorithmClient();

    public void upload(MultipartFile file, Long userId) {
        String base64String = null;
        try {
            byte[] imgBytes = file.getBytes();
            base64String = Base64.getEncoder().encodeToString(imgBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (base64String == null) {
            throw new RuntimeException();
        }

        Long imgId = imageDao.insertImage(base64String);

        AssessmentRequest request = new AssessmentRequest();
        request.setBase64Image(base64String);
        AssessmentResponse response = client.assess(request);

        assessDao.insertAssess(
            Assessment.builder().score(response.getScore()).comment(response.getComment()).characterName(response.getCharName()).userId(userId)
                .imageId(imgId).build());
    }

    public byte[] getImage(Long assessId) {
        Long imageId = assessDao.selectAssessById(assessId).getImageId();
        String imageData = imageDao.selectImageById(imageId);
        return Base64.getDecoder().decode(imageData);
    }

    public List<Assessment> queryAll() {
        return assessDao.selectAllAssess();
    }

    public GetInfoResponse getInfo(String charName) {
        return client.getInfo(charName);
    }
}
