package cn.csu.ykf.inkin.console.dao.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csu.ykf.inkin.common.model.po.Image;
import cn.csu.ykf.inkin.console.mapper.ImageMapper;

@Service
public class ImageDao {

    @Autowired
    ImageMapper imageMapper;

    public Long insertImage(String base64Image) {
        Image image = new Image();
        image.setBase64Image(base64Image);
        return (long) imageMapper.insert(image);
    }

    public String selectImageById(Long id) {
        return imageMapper.selectById(id).getBase64Image();
    }
}
