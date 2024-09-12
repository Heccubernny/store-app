package com.mama.pride.controllers;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mama.pride.services.UserProfileService;

@RestController
@RequestMapping(name = "/api/user")
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/{userId}/upload-profile-picture")
    public void uploadProfilePicture(@PathVariable Integer userId, @RequestParam MultipartFile file)
            throws IOFileUploadException {
        userProfileService.uploadProfilePicture(userId, file);
    }

    @GetMapping("/{userId}/profile-picture")
    public byte[] downloadProfilePicture(@PathVariable Integer userId) throws IOFileUploadException {
        return userProfileService.downloadProfilePicture(userId);
    }

    @DeleteMapping("/{userId}/profile-picture")
    public void deleteProfilePicture(@PathVariable Integer userId) throws IOFileUploadException {
        userProfileService.deleteProfilePicture(userId);
    }

}
