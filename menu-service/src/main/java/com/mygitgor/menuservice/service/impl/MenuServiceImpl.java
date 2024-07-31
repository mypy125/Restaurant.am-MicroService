package com.mygitgor.menuservice.service.impl;

import com.mygitgor.menuservice.entity.Category;
import com.mygitgor.menuservice.entity.Food;
import com.mygitgor.menuservice.entity.IngredientCategory;
import com.mygitgor.menuservice.entity.IngredientItem;
import com.mygitgor.menuservice.repository.CategoryRepository;
import com.mygitgor.menuservice.repository.FoodRepository;
import com.mygitgor.menuservice.repository.IngredientCategoryRepository;
import com.mygitgor.menuservice.repository.IngredientItemRepository;
import com.mygitgor.menuservice.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final CategoryRepository categoryRepository;
    private final FoodRepository foodRepository;
    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final IngredientItemRepository ingredientItemRepository;

    public MenuServiceImpl(CategoryRepository categoryRepository,
                           FoodRepository foodRepository,
                           IngredientCategoryRepository ingredientCategoryRepository,
                           IngredientItemRepository ingredientItemRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.foodRepository = foodRepository;
        this.ingredientCategoryRepository = ingredientCategoryRepository;
        this.ingredientItemRepository = ingredientItemRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public List<Food> getAllFoods() {
        return List.of();
    }

    @Override
    public Food createFood(Food food) {
        return null;
    }

    @Override
    public List<IngredientCategory> getAllIngredientCategories() {
        return List.of();
    }

    @Override
    public IngredientCategory createIngredientCategory(IngredientCategory ingredientCategory) {
        return null;
    }

    @Override
    public List<IngredientItem> getAllIngredients() {
        return List.of();
    }

    @Override
    public IngredientItem createIngredient(IngredientItem ingredientItem) {
        return null;
    }
}
