package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++); // this will be making a unique id for each category
        categories.add(category);
    }


   @Override
   public String deleteCategory(Long categoryId) {
       Category category = categories.stream()
               .filter(c -> c.getCategoryId().equals(categoryId)) // a for eah loop
               .findFirst().orElse(null); // returns the first element that matches the condition if not then null
       if(category == null)
           return"Category not found"; // if category asked is not found
       categories.remove(category); // important statement for deletion
       return "Category with categoryId: "+ categoryId +" deleted successfully";
   }
}
