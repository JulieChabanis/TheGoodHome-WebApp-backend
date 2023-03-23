package com.webapp.thegoodhomebackend;

import com.webapp.thegoodhomebackend.entity.ImageEntity;
import com.webapp.thegoodhomebackend.repository.ImageRepository;
import com.webapp.thegoodhomebackend.service.ImageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageServiceTest {

    @Mock
    private ImageRepository imageRepository;

    @InjectMocks
    private ImageService imageService;

    @Test
    void testGetImages() {
        List<ImageEntity> images = new ArrayList<>();
        ImageEntity imageEntity1 = new ImageEntity(1L, "image1.jpg", "image/jpeg", new byte[]{});
        ImageEntity imageEntity2 = new ImageEntity(2L, "image2.jpg", "image/jpeg", new byte[]{});
        images.add(imageEntity1);
        images.add(imageEntity2);

        when(imageRepository.findAll()).thenReturn(images);

        List<ImageEntity> result = imageService.getImages();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("image1.jpg", result.get(0).getFileName());
        assertEquals("image/jpeg", result.get(0).getMimeType());
        assertArrayEquals(new byte[]{}, result.get(0).getData());
    }

    @Test
    void testGetImageById() {
        ImageEntity imageEntity1 = new ImageEntity(1L, "image1.jpg", "image/jpeg", new byte[]{});
        when(imageRepository.findById(1L)).thenReturn(Optional.of(imageEntity1));

        ImageEntity result = imageService.getImageById(1L);

        assertNotNull(result);
        assertEquals("image1.jpg", result.getFileName());
        assertEquals("image/jpeg", result.getMimeType());
        assertArrayEquals(new byte[]{}, result.getData());
    }

    @Test
    void testUploadImage() throws IOException {
        String fileName = "test.jpg";
        String mimeType = "image/jpeg";
        byte[] data = new byte[]{1, 2, 3};

        MockMultipartFile mockMultipartFile = new MockMultipartFile(fileName, fileName, mimeType, data);

        when(imageRepository.save(any(ImageEntity.class))).thenReturn(new ImageEntity(1L, fileName, mimeType, data));

        ImageEntity result = imageService.uploadImage(mockMultipartFile);

        assertNotNull(result);
        assertEquals(fileName, result.getFileName());
        assertEquals(mimeType, result.getMimeType());
        assertArrayEquals(data, result.getData());
    }

    @Test
    void testUpdateImage() {
        Long id = 1L;
        String originalFileName = "test.jpg";
        String originalMimeType = "image/jpeg";
        byte[] originalData = new byte[]{1, 2, 3};
        ImageEntity originalImage = new ImageEntity(id, originalFileName, originalMimeType, originalData);

        String updatedFileName = "updated.jpg";
        String updatedMimeType = "image/png";
        byte[] updatedData = new byte[]{4, 5, 6};
        ImageEntity updatedImage = new ImageEntity(id, updatedFileName, updatedMimeType, updatedData);

        when(imageRepository.findById(id)).thenReturn(Optional.of(originalImage));

        when(imageRepository.save(any(ImageEntity.class))).thenReturn(updatedImage);

        ImageEntity result = imageService.updateImage(id, updatedFileName, updatedMimeType, updatedData);

        assertNotNull(result);
        assertEquals(updatedFileName, result.getFileName());
        assertEquals(updatedMimeType, result.getMimeType());
        assertArrayEquals(updatedData, result.getData());
    }

    @Test
    void testDeleteImageById() {
        ImageEntity imageEntity = new ImageEntity(1L, "test.jpg", "image/jpeg", new byte[]{1, 2, 3});

        when(imageRepository.findById(1L)).thenReturn(Optional.of(imageEntity));

        imageService.deleteImageById(1L);

        verify(imageRepository, times(1)).deleteById(1L);
    }







}
