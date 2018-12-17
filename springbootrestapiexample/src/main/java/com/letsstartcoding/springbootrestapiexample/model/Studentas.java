package com.letsstartcoding.springbootrestapiexample.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="studentas")
@EntityListeners(AuditingEntityListener.class)
public class Studentas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String vardas;
	
	@NotBlank
	private String pavarde;
	
	@NotBlank
	private String grupe;
	
	//@NotBlank
	private Long kursas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}

	public String getGrupe() {
		return grupe;
	}

	public void setGrupe(String grupe) {
		this.grupe = grupe;
	}

	public Long getKursas() {
		return kursas;
	}

	public void setKursas(Long kursas) {
		this.kursas = kursas;
	}
}
