package com.tka.OrganizationSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	
	String cname;
	
	
		
	
	
	
}
