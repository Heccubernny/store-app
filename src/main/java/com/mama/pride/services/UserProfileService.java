package com.mama.pride.services;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.web.multipart.MultipartFile;

import com.mama.pride.entities.UserProfile;

public interface UserProfileService {
    UserProfile saveUserProfile(UserProfile userProfile);

    UserProfile getUserProfile(Integer id);

    void uploadProfilePicture(Integer userId, MultipartFile file) throws IOFileUploadException;

    byte[] downloadProfilePicture(Integer userId) throws IOFileUploadException;

    void deleteProfilePicture(Integer userId) throws IOFileUploadException;
}
