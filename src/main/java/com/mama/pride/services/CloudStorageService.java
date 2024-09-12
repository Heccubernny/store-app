package com.mama.pride.services;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudStorageService {
    String uploadFile(MultipartFile file) throws IOFileUploadException;

    byte[] downloadFile(String fileUrl) throws IOFileUploadException;

    void deleteFile(String fileUrl) throws IOFileUploadException;
}
