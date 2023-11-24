package com.yumamur.firstweb;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageController {
    public static ResponseEntity<byte[]> getImage(String path) throws IOException {
        Resource img = new ClassPathResource(path);

        if (path.endsWith(".png")) {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(Files.readAllBytes(Path.of(img.getURI())));
        }
        else if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(Files.readAllBytes(Path.of(img.getURI())));
        }
        else
            return null;
    }
}
