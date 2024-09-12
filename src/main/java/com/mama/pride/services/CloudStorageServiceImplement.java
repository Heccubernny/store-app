package com.mama.pride.services;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CloudStorageServiceImplement implements CloudStorageService {

    @Override
    public String uploadFile(MultipartFile file) throws IOFileUploadException {
        // Implement upload logic to Azure Blob Storage
        // return the uploaded file url or path
        return "Uploaded-file-url";
    }

    @Override
    public byte[] downloadFile(String fileUrl) throws IOFileUploadException {
        // Implement download logic
        return new byte[0];
    }

    @Override
    public void deleteFile(String fileUrl) throws IOFileUploadException {
        // implement delete logic
    }

}
