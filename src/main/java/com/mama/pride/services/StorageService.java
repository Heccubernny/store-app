package com.mama.pride.services;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String store(MultipartFile file);

    Resource load(String fileName);

    List<String> loadAll() throws Exception;

    void delete(String fileName) throws Exception;
}
