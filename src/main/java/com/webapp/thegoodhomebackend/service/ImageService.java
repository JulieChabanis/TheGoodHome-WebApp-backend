package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.ImageEntity;
import com.webapp.thegoodhomebackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    public List<ImageEntity> getImages() {

        return imageRepository.findAll();
    }

    public ImageEntity getImageById(Long id) {
        Optional<ImageEntity> imageEntity = imageRepository.findById(id);
        if (imageEntity.isPresent()) {
            return imageEntity.get();
        } else {
            throw new RuntimeException("Images to get not found with id" + id);
        }
    }

    public ImageEntity uploadImage(MultipartFile file) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setData(file.getBytes());
        imageEntity.setFileName(file.getOriginalFilename());
        imageEntity.setMimeType(file.getContentType());
        return imageRepository.save(imageEntity);
    }

    public ImageEntity updateImage(Long id, String fileName, String mimeType, byte[] data) {
        // Recherche de l'image à mettre à jour
        Optional<ImageEntity> imageOptional = imageRepository.findById(id);
        if (!imageOptional.isPresent()) {
            throw new IllegalArgumentException("Image not found with ID " + id);
        }

        // Mise à jour des attributs de l'image
        ImageEntity image = imageOptional.get();
        image.setFileName(fileName);
        image.setMimeType(mimeType);
        image.setData(data);

        // Enregistrement de l'image mise à jour
        return imageRepository.save(image);
    }


    public void deleteImageById(Long id) {

        Optional<ImageEntity> imageEntity = imageRepository.findById(id);
        if (imageEntity.isPresent()) {
            imageRepository.deleteById(id);
        } else {
            throw new RuntimeException("Image not found with id" + id);
        }
    }
}
