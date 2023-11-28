package com.i2i.ievolv.controller;

import com.i2i.ievolv.dto.CategoryDTO;
import com.i2i.ievolv.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/", params = {"id"})
    public ResponseEntity<CategoryDTO> getCategoryById(@RequestParam final Long id) {
        CategoryDTO categoryDTO = categoryService.findCategoryById(id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOs = categoryService.findCategories();
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
}
