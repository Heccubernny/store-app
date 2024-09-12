package com.mama.pride.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mama.pride.entities.Category;
import com.mama.pride.exceptions.ResourceNotFoundException;
import com.mama.pride.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "https://localhost:8008")
@RequestMapping(value = "/api/categories")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Operation(summary = "Get all Categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Categories", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class)) }),
            @ApiResponse(responseCode = "503", description = "Invalid response", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categories not found", content = @Content) })

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories == null)
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResourceNotFoundException("Categories not found");

        return ResponseEntity.ok(categories);
    }

}