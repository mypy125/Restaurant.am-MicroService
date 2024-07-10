package com.mygitgor.menuservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Long price;


    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

    private boolean available;

    private boolean isVegetarian;
    private boolean isSeasonal;

    @ManyToMany
    private List<IngredientItem> ingredients = new ArrayList<>();

    private Date createondate;
}