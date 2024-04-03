package com.art.artproject.service.impl;

import com.art.artproject.dto.CategoryResponse;
import com.art.artproject.dto.NewCategoryRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Category;
import com.art.artproject.repo.CategoryRepo;
import com.art.artproject.service.CardService;
import com.art.artproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryService categoryService;



    @Autowired
    private ModelMapper mapper;
    @Override
    public CategoryResponse saveNewCategory(NewCategoryRequest request) {
        Category category=Category.of(request);
        return mapper.map(categoryRepo.save(category),CategoryResponse.class);
    }
    @Override
    public List<Category> showWithType(Long category_id) {

        List<Category> categories=categoryService.findAll();
        List<Category> filterCategories=new ArrayList<>();
        for(Category category: categories){
            if (category.getId()==category_id){
                filterCategories.add(category);
            }
        }
        return filterCategories;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void delete(Long id) {

        if (categoryRepo.existsById(id)){
            categoryRepo.deleteById(id);

        }
    }

    @Override
    public Category update(Long id,NewCategoryRequest request) {
        Optional<Category> category=categoryRepo.findById(id);
        if(category.isPresent()){
            Category category1=category.get();
            category1.setName(request.getName());
            return category1;
        }
        return null;
//        authorRepo.save(AuthorRequest.getAuthor(authorRequest));
    }




}
