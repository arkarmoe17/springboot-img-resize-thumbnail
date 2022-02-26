package com.arkarmoe.springbootimgresize.controller;

import com.arkarmoe.springbootimgresize.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
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
}
