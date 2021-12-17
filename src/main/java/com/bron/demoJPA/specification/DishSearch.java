package com.bron.demoJPA.specification;

import com.bron.demoJPA.appuser.AppUser;

import lombok.AllArgsConstructor;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishSearch {

	private Long dishId;
	private String dname;
	private String description;
	private double price;
	private boolean vegan;
	private boolean glutenFree;
	private boolean eggFree;
	private AppUser app;
	
	public boolean getVegan() {
		return vegan;
	}
	public boolean getEggFree() {
		return eggFree;
	}
	public boolean getGlutenFree() {
		return glutenFree;
	}

}
