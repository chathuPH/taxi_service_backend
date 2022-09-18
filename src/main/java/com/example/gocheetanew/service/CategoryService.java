package com.example.gocheetanew.service;

import com.example.gocheetanew.dto.CategoryDto;
import com.example.gocheetanew.model.Category;
import com.example.gocheetanew.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category addNewCategory(Category category ) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }

    public Category findById(long id){
        return  categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("category not found"));
    }
}
