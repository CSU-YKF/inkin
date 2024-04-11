package cn.csu.ykf.inkin.console.controller.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;

import cn.csu.ykf.inkin.common.model.dto.info.GetInfoResponse;
import cn.csu.ykf.inkin.common.model.po.Assessment;
import cn.csu.ykf.inkin.console.dao.AssessDao;
import cn.csu.ykf.inkin.console.dao.image.ImageDao;
import cn.csu.ykf.inkin.console.service.AssessService;

@RestController
public class ImageController {

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private AssessDao assessDao;

    private AssessService assessService = new AssessService();

//    @PostMapping
//    public UploadResponse upload(@RequestBody UploadRequest request) {
//        Long userId = request.getUserId();
//        UploadResponse response = new UploadResponse();
//        Long imageId = imageDao.insertImage(request.getImage());
//        response.setImageId(imageId);
//        AlgorithmClient client = new AlgorithmClient();
//        client.assess(null);
//        assessDao.insertAssess(null);
//        return response;
//    }

    @PostMapping("/upload")
    @CrossOrigin
    public ResponseEntity<Object> uploadImage(MultipartFile file, Long userId) {
        assessService.upload(file, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping("/getImage")
    public ResponseEntity<byte[]> getImage(@RequestParam("id") long id) {
        byte[] image = assessService.getImage(id);
        HttpHeaders getImageHeaders = new HttpHeaders();
        getImageHeaders.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image, getImageHeaders, HttpStatus.OK);
    }


    @RequestMapping("/queryAll")
    @CrossOrigin
    public ResponseEntity<List<Assessment>> queryAll() {
        return new ResponseEntity<>(assessService.queryAll(), HttpStatus.OK);
    }

    @RequestMapping("queryInfo")
    @CrossOrigin
    public ResponseEntity<GetInfoResponse> queryInfo(@RequestParam("char") String charName) {
        GetInfoResponse getInfoResponse = assessService.getInfo(charName);
        return new ResponseEntity<>(getInfoResponse, HttpStatus.OK);
    }
}
