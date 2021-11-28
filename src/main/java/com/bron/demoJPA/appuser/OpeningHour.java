package com.bron.demoJPA.appuser;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Opening_hour_info"
		)

public class OpeningHour {
	@Id
	@SequenceGenerator(
			name = "opening_hour_sequence", sequenceName = "opening_hour_sequence", allocationSize = 1)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, generator = "opening_hour_sequence")
	@Column(name ="OpeningHour_ID")
	private Long openingHourID;	
	
	
	@Column(name ="Rest_Opening_Hour_Monday")
	private String openingHourMon;
	
	@Column(name ="Rest_Closing_Hour_Monday")
	private String closingHourMon;
	
	@Column(name ="Rest_Opening_Hour_Tuesday")
	private String openingHourTue;
	
	@Column(name ="Rest_Closing_Hour_Tuesday")
	private String closingHourTue;
	
	@Column(name ="Rest_Opening_Hour_Wednesday")
	private String openingHourWed;
	
	@Column(name ="Rest_Closing_Hour_Wednesday")
	private String closingHourWed;
	
	@Column(name ="Rest_Opening_Hour_Thursday")
	private String openingHourThurs;
	
	@Column(name ="Rest_Closing_Hour_Thursday")
	private String closingHourThurs;

	@Column(name ="Rest_Opening_Hour_Friday")
	private String openingHourFri;
	
	@Column(name ="Rest_Closing_Hour_Friday")
	private String closingHourFri;
	
	@Column(name ="Rest_Opening_Hour_Saturday")
	private String openingHourSat;
	
	@Column(name ="Rest_Closing_Hour_Saturday")
	private String closingHourSat;
	
	@Column(name ="Rest_Opening_Hour_Sunday")
	private String openingHourSun;
	
	@Column(name ="Rest_Closing_Hour_Sunday")
	private String closingHourSun;
	

	@OneToOne(fetch = FetchType.LAZY, optional = true)
		//cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)

	@JoinColumn(name = "id", referencedColumnName = "Rest_ID")
	private AppUser appUser; 
			
			
	
}
