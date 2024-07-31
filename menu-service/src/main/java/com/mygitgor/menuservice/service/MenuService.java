package com.mygitgor.menuservice.service;

import com.mygitgor.menuservice.entity.Category;
import com.mygitgor.menuservice.entity.Food;
import com.mygitgor.menuservice.entity.IngredientCategory;
import com.mygitgor.menuservice.entity.IngredientItem;

import java.util.List;

public interface MenuService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    List<Food> getAllFoods();
    Food createFood(Food food);
    List<IngredientCategory> getAllIngredientCategories();
    IngredientCategory createIngredientCategory(IngredientCategory ingredientCategory);
    List<IngredientItem> getAllIngredients();
    IngredientItem createIngredient(IngredientItem ingredientItem);
}
