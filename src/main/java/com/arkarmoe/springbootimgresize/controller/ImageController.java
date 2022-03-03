package com.arkarmoe.springbootimgresize.controller;

import com.arkarmoe.springbootimgresize.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello welcome from image resizable project.";
    }

    //resize image
    @GetMapping("/resize")
    public void resizeImage() throws IOException {
        imageService.resizeImage();
    }

    @GetMapping("/extension")
    public String getExtension(@RequestParam("fileName")String fileName){
        String fileExt =  getExtensionByApacheCommonLib(fileName);
        if(fileExt.isEmpty())
            System.out.println("file is empty");
        return fileExt;
    }

    public String getExtensionByApacheCommonLib(String filename) {
        return FilenameUtils.getExtension(filename);
    }
}
