package com.mygitgor.menuservice.controller.request;

import com.mygitgor.menuservice.entity.IngredientCategory;

public record CreateIngredientItemRequest(
        String name,
        IngredientCategory category
){
}
