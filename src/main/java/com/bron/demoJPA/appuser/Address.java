package com.bron.demoJPA.appuser;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable 
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@AttributeOverrides({	
	
		@AttributeOverride(		
				name = "lineone",
				column = @Column(name = "Address_1")
				),
		
	   	@AttributeOverride(
			name = "linetwo",
			column = @Column(name = "Address_2")
				),
		
				@AttributeOverride(
					name = "town",
					column = @Column(name = "Address_3")
				),
				
				@AttributeOverride(
						name = "city",
						column = @Column(name = "rest_city")
				),
				
				@AttributeOverride(
						name = "postcode",
						column = @Column(name = "rest_postcode")				
						)
		
})			
		
		
public class Address {
	
	private String lineone;
	
	private String linetwo;
	
	private String town;
	
	private String city;
	
	private String postcode;
	
	

}
