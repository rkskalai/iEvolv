package com.i2i.ievolv.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.ievolv.dto.CategoryDTO;
import com.i2i.ievolv.entities.Category;
import com.i2i.ievolv.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    ObjectMapper mapper = new ObjectMapper();

    public CategoryDTO findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return mapper.convertValue(category.get(), CategoryDTO.class);
        }
        return null;
    }

    public List<CategoryDTO> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(!categories.isEmpty()) {
            return categories.stream().map(category -> mapper.convertValue(category, CategoryDTO.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       Category savedCategory = categoryRepository.save(mapper.convertValue(categoryDTO, Category.class));
       return mapper.convertValue(savedCategory, CategoryDTO.class);
    }
}
