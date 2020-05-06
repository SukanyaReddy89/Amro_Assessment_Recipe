package com.abn.backend.ejb;

import java.util.List;

import javax.ejb.Stateless;

@Stateless(name = "ProtiensProcessor")
public class ProtiensProcessorBean implements ProtiensProcessor{
 	  public float computeProtiens(List<Ingredient> ingredients) {
 		 return ProtienProcessorUtil.calculateTotalProtiens(ingredients);
	    }
}
