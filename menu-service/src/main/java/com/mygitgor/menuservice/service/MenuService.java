package com.mygitgor.menuservice.service;

import com.mygitgor.menuservice.controller.request.CreateCategoryRequest;
import com.mygitgor.menuservice.controller.request.CreateFoodRequest;
import com.mygitgor.menuservice.controller.request.CreateIngredientCategory;
import com.mygitgor.menuservice.controller.request.CreateIngredientItemRequest;
import com.mygitgor.menuservice.entity.Category;
import com.mygitgor.menuservice.entity.Food;
import com.mygitgor.menuservice.entity.IngredientCategory;
import com.mygitgor.menuservice.entity.IngredientItem;

import java.util.List;

public interface MenuService {
    List<Category> getAllCategories();
    Category createCategory(CreateCategoryRequest request);
    List<Food> getAllFoods();
    Food createFood(CreateFoodRequest request);
    List<IngredientCategory> getAllIngredientCategories();
    IngredientCategory createIngredientCategory(CreateIngredientCategory request);
    List<IngredientItem> getAllIngredients();
    IngredientItem createIngredient(CreateIngredientItemRequest request);
}
