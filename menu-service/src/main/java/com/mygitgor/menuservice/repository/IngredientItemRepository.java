package com.mygitgor.menuservice.repository;

import com.mygitgor.menuservice.entity.IngredientItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientItemRepository extends JpaRepository<IngredientItem, Long> {
}
