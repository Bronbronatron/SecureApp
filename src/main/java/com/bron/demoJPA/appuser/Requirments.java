package com.bron.demoJPA.appuser;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Table(name = "Require_info"
)
public class Requirments {
	@Id
	@SequenceGenerator(name = "require_sequence", sequenceName = "require_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "require_sequence")

	@Column(name = "Require_ID")
	Long requireId;

	@Column(name = "Require_Name")
	String requireName;

	}


