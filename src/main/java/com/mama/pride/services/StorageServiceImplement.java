package com.mama.pride.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@Component
public class StorageServiceImplement implements StorageService {

    @Value("${basepath.upload.files}")
    private String BASEPATH;

    @Override
    public String store(MultipartFile file) {
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        File filePath = new File(BASEPATH, fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            FileCopyUtils.copy(file.getInputStream(), fileOutputStream);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Resource load(String fileName) {
        File filePath = new File(BASEPATH, fileName);
        if (!filePath.exists()) {
            return null;
        } else {
            return new FileSystemResource(filePath);
        }
    }

    @Override
    public List<String> loadAll() {
        File dirPath = new File(BASEPATH);
        return List.of(dirPath.list());

    }

    @Override
    public void delete(String fileName) throws Exception {
        File filePath = new File(BASEPATH, fileName);
        if (!filePath.exists()) {
            throw new Exception("Could not find file " + fileName);
        } else {
            filePath.delete();
        }
    }

}
