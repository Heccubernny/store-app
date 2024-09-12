package com.mama.pride.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mama.pride.entities.UserProfile;

public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {
    @SuppressWarnings({ "null", "unchecked" })
    UserProfile save(UserProfile userProfile);

    UserProfile findByUserId(int userId);

    @SuppressWarnings("null")
    List<UserProfile> findAll();

    UserProfile findByEmail(String email);

    UserProfile findByUsername(String username);

}
