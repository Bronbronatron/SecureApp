package com.bron.demoJPA.appuser;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@ToString(exclude = "reqlist")
public class Dish {
	
	@Id
	@SequenceGenerator(
		name = "dish_sequence",
		sequenceName = "dish_sequence",
		allocationSize = 1
			)
	
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "dish_sequence"
			)
	@Column(name ="dish_Id")
	private Long dishId;
	
	@Column(name ="dish_name")
	private String dname;
	
	@Column(name ="dish_description")
	private String description;
	
	@Column(name ="dish_price")
	private double price;	
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name ="Rest_ID",
			referencedColumnName = "Rest_ID"
			)
	
//	@Column(name ="dish_restaurant")
	private AppUser app;	
	
	
	@ManyToMany(
			cascade = CascadeType.ALL
			)
  @JoinTable(name = "dish_requirment_mapping", joinColumns = @JoinColumn(name = "dish_Id", referencedColumnName = "dish_Id"), inverseJoinColumns = @JoinColumn(
   name = "Require_ID", referencedColumnName = "Require_ID"))
	private List <Requirments> reqlist;

	public void addRequirments(Requirments req) {
		if (reqlist == null)
			reqlist = new ArrayList<>();
		reqlist.add(req);

}
}

