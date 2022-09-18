package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.CategoryDto;
import com.example.gocheetanew.model.Category;
import com.example.gocheetanew.model.Vehicle;
import com.example.gocheetanew.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody CategoryDto categoryDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;

        if(categoryDto==null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        return new ResponseEntity<>(categoryService.addNewCategory(category),response);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody CategoryDto categoryDto) {

        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;

        if(categoryDto == null){
            throw new RuntimeException("id cannot be null");
        }else{
            response = HttpStatus.CREATED;

        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategoryName());
        return new ResponseEntity<>(categoryService.addNewCategory(category),response);


    }

    @DeleteMapping("/delete")
    public ResponseEntity<Category> delete(@RequestParam(name = "id") long id) {

        HttpStatus response = HttpStatus.EXPECTATION_FAILED;
        Category deleted = categoryService.findById(id);

        try{
            categoryService.deleteCategory(id);
            response = HttpStatus.ACCEPTED;

        }catch (Exception e){
            response = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(deleted, response);

    }

    @GetMapping("/findById")
    public ResponseEntity<Category> findById(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(categoryService.findById(Long.parseLong(id)),HttpStatus.OK);
    }


}
