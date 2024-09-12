package com.mama.pride.services;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mama.pride.dao.UserProfileDao;
import com.mama.pride.entities.UserProfile;
import com.mama.pride.exceptions.ResourceNotFoundException;

@Service
public class UserProfileServiceImplement implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private CloudStorageService cloudStorageService;

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileDao.save(userProfile);
    }

    @Override
    public UserProfile getUserProfile(Integer id) {
        return userProfileDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }

    @Override
    public void uploadProfilePicture(Integer userId, MultipartFile file) throws IOFileUploadException {
        UserProfile userProfile = getUserProfile(userId);

        // Upload the file to cloud storage and get the URL
        String imageUrl = cloudStorageService.uploadFile(file);

        // Update the user profile with image URL
        userProfile.setProfilePicture(imageUrl);
        saveUserProfile(userProfile);

    }

    @Override
    public byte[] downloadProfilePicture(Integer userId) throws IOFileUploadException {
        UserProfile userProfile = getUserProfile(userId);
        String imageUrl = userProfile.getProfilePicture();

        // Download the image from azure blob storage
        return cloudStorageService.downloadFile(imageUrl);
    }

    @Override
    public void deleteProfilePicture(Integer userId) throws IOFileUploadException {
        UserProfile userProfile = getUserProfile(userId);
        String imageUrl = userProfile.getProfilePicture();

        // Delete the image from cloud storage
        cloudStorageService.deleteFile(imageUrl);

        // Remove the image Url from the user profile

        userProfile.setProfilePicture(null);
        saveUserProfile(userProfile);
    }

}
