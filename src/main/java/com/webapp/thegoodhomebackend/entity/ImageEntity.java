package com.webapp.thegoodhomebackend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name ="images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "file_name" )
    private String fileName;

    @Column(name ="mime_type")
    private String mimeType;

    @Lob
    @Column(name = "data")
    private byte[] data;

    @ManyToOne
    private AppartmentEntity appartment;


    public ImageEntity(Long id, String fileName, String mimeType, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public AppartmentEntity getAppartment() {
        return appartment;
    }

    public void setAppartment(AppartmentEntity appartment) {
        this.appartment = appartment;
    }




}
