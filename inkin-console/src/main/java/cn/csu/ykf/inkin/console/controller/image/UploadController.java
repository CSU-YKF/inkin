package cn.csu.ykf.inkin.console.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.csu.ykf.inkin.common.model.dto.upload.UploadRequest;
import cn.csu.ykf.inkin.common.model.dto.upload.UploadResponse;
import cn.csu.ykf.inkin.console.dao.AssessDao;
import cn.csu.ykf.inkin.console.dao.image.ImageDao;
import cn.csu.ykf.inkin.core.client.AlgorithmClient;

@RestController("/image")
public class UploadController {

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private AssessDao assessDao;

    @PostMapping
    public UploadResponse upload(@RequestBody UploadRequest request) {
        Long userId = request.getUserId();
        UploadResponse response = new UploadResponse();
        Long imageId = imageDao.insertImage(request.getImage());
        response.setImageId(imageId);
        AlgorithmClient client = new AlgorithmClient();
        client.assess(null);
        assessDao.insertAssess(null);
        return response;
    }
}
