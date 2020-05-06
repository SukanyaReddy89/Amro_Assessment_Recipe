package com.abn.backend.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ProtiensProcessor {
    float computeProtiens(List<Ingredient> ingredients);
}
