package com.abn.backend.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CaloriesProcessor {
    float computeCalories(List<Ingredient> ingredients);
}
