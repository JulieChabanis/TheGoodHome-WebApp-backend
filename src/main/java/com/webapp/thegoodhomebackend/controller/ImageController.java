package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.ImageEntity;
import com.webapp.thegoodhomebackend.repository.ImageRepository;
import com.webapp.thegoodhomebackend.service.ImageService;
import com.webapp.thegoodhomebackend.utils.ImageUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:3000")

public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;


    @GetMapping("")
    public List<ImageEntity> getImages(){
        return imageService.getImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        ImageEntity imageEntity = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image with id " + id + " not found"));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageEntity.getFileName() + "\"")
                .body(imageEntity.getData());
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            String fileName = file.getOriginalFilename();
            String mimeType = ImageUtils.getMimeType(fileName);
            ImageEntity imageEntity = new ImageEntity(1L, fileName, mimeType, data);
            imageRepository.save(imageEntity);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            ImageEntity imageEntity = imageRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Image with id " + id + " not found"));
            byte[] data = file.getBytes();
            String fileName = file.getOriginalFilename();
            String mimeType = ImageUtils.getMimeType(fileName);

            imageEntity.setData(data);
            imageEntity.setFileName(fileName);
            imageEntity.setMimeType(mimeType);

            imageRepository.save(imageEntity);

            return ResponseEntity.ok("Image updated successfully");
        } catch (IOException | EntityNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteImageById(@PathVariable Long id) {
            try {
                ImageEntity imageEntity = imageRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Image with id " + id + " not found"));
                imageRepository.delete(imageEntity);
                return ResponseEntity.ok("Image deleted successfully");
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
}

