package com.mygitgor.menuservice.controller;

import com.mygitgor.menuservice.controller.request.CreateCategoryRequest;
import com.mygitgor.menuservice.controller.request.CreateFoodRequest;
import com.mygitgor.menuservice.controller.request.CreateIngredientCategory;
import com.mygitgor.menuservice.controller.request.CreateIngredientItemRequest;
import com.mygitgor.menuservice.entity.Category;
import com.mygitgor.menuservice.entity.Food;
import com.mygitgor.menuservice.entity.IngredientCategory;
import com.mygitgor.menuservice.entity.IngredientItem;
import com.mygitgor.menuservice.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return menuService.getAllCategories();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryRequest request) {
        Category createdCategory = menuService.createCategory(request);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return menuService.getAllFoods();
    }

    @PostMapping("/foods")
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest request) {
        Food createdFood = menuService.createFood(request);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @GetMapping("/ingredient-categories")
    public List<IngredientCategory> getAllIngredientCategories() {
        return menuService.getAllIngredientCategories();
    }

    @PostMapping("/ingredient-categories")
    public ResponseEntity<IngredientCategory> createIngredientCategory(@RequestBody CreateIngredientCategory request) {
        IngredientCategory createdIngredientCategory = menuService.createIngredientCategory(request);
        return new ResponseEntity<>(createdIngredientCategory, HttpStatus.CREATED);
    }

    @GetMapping("/ingredients")
    public List<IngredientItem> getAllIngredients() {
        return menuService.getAllIngredients();
    }

    @PostMapping("/ingredients")
    public ResponseEntity<IngredientItem> createIngredient(@RequestBody CreateIngredientItemRequest request) {
        IngredientItem createdIngredientItem = menuService.createIngredient(request);
        return new ResponseEntity<>(createdIngredientItem, HttpStatus.CREATED);
    }
}
