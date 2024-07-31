package com.mygitgor.menuservice.service.impl;

import com.mygitgor.menuservice.controller.request.CreateCategoryRequest;
import com.mygitgor.menuservice.controller.request.CreateFoodRequest;
import com.mygitgor.menuservice.controller.request.CreateIngredientCategory;
import com.mygitgor.menuservice.controller.request.CreateIngredientItemRequest;
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
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CreateCategoryRequest request) {
        Category createCategory = new Category(request.categoryName());
        return categoryRepository.save(createCategory);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food createFood(CreateFoodRequest request) {
        Food createFood = new Food(request.name(),
                request.description(),
                request.price(),
                request.category(),
                request.images()
                );
        return foodRepository.save(createFood);
    }

    @Override
    public List<IngredientCategory> getAllIngredientCategories() {
        return ingredientCategoryRepository.findAll();
    }

    @Override
    public IngredientCategory createIngredientCategory(CreateIngredientCategory request) {
        IngredientCategory createIngredientCategory = new IngredientCategory(request.name());
        return ingredientCategoryRepository.save(createIngredientCategory);
    }

    @Override
    public List<IngredientItem> getAllIngredients() {
        return ingredientItemRepository.findAll();
    }

    @Override
    public IngredientItem createIngredient(CreateIngredientItemRequest request) {
        IngredientItem createIngredientItem = new IngredientItem(request.name(), request.category());
        return ingredientItemRepository.save(createIngredientItem);
    }
}
