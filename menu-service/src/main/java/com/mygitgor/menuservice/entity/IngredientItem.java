package com.mygitgor.menuservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class IngredientItem extends BaseEntity{
    private String name;

    @ManyToOne
    private IngredientCategory category;

}