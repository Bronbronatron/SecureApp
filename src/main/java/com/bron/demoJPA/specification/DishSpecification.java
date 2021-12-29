
package com.bron.demoJPA.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.AppUser_;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.appuser.Dish_;

public class DishSpecification implements Specification<Dish>  {
	
	private final DishSearch criteria;
	
    public DishSpecification(DishSearch ds) {
        criteria =ds;
    }

	@Override
	public Predicate toPredicate(Root<Dish> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
       Join<Dish, AppUser> o = root.join(Dish_.app);
       	
       Path<AppUser> app = root.get(Dish_.app);
       Path<String> city = app.get(AppUser_.city);
       Path<String> dname = root.get(Dish_.dname);
       Path<Boolean> vegan= root.get(Dish_.vegan);
       Path<Boolean> eggFree= root.get(Dish_.eggFree);
       Path<Boolean> glutenFree= root.get(Dish_.glutenFree);
        
 
        final List<Predicate> predicates = new ArrayList<Predicate>();
        
        if(criteria.getDname()!=null) {
            predicates.add(cb.equal(dname, criteria.getDname()));
        }
 
        if(criteria.getApp().getCity() != null) {
            predicates.add(cb.equal(city, criteria.getApp().getCity()));
        }
 
        if(criteria.isVegan()!=false) {
            predicates.add(cb.equal(vegan, criteria.isVegan()));
        }
        
        if(criteria.isEggFree()!=false) {
            predicates.add(cb.equal(eggFree, criteria.isEggFree()));
        }
        
        if(criteria.isGlutenFree()!=false) {
            predicates.add(cb.equal(glutenFree, criteria.isGlutenFree()));
        }
	
        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
}
}

