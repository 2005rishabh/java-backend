package com.swagger.entity;

import java.util.List;

import lombok.Data;

@Data

public class Tacos {
    private String name;
    private List<Ingredients> ingredients;
}
