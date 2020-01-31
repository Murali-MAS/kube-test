package com.demo.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Integer candidateId;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private String address;
	@Getter @Setter private String dob;
	@Getter @Setter private String doi;
	@Getter @Setter private String doe;
	@Getter @Setter private String rto;
}
