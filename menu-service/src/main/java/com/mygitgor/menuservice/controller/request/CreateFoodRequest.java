package com.mygitgor.menuservice.controller.request;

import com.mygitgor.menuservice.entity.Category;
import java.util.List;

public record CreateFoodRequest(
        String name,
        String description,
        Long price,
        Category category,
        List<String> images
) {
}
