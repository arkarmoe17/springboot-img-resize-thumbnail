package com.arkarmoe.springbootimgresize.service.impl;

import com.arkarmoe.springbootimgresize.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class IImageService implements ImageService {

    @Override
    public void resizeImage() throws IOException {
        String path = "src/main/resources/images/user_img.jpg";
        log.info("file path:{}",path);
        File file = new File(path);
        Path photoPath = Paths.get(path).getParent();
        Path fileName = Paths.get(path).getFileName();
        log.info("photoPath:{} | fileName:{}", photoPath, fileName);
        String thumbNailPath = photoPath + File.separator + "thumbnail" + File.separator + fileName;
        log.info("thumbnail file:{}", thumbNailPath);
        File thumbnailFile = new File(thumbNailPath);
        try {
            Thumbnails.of(file).size(100, 100).toFile(thumbnailFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
