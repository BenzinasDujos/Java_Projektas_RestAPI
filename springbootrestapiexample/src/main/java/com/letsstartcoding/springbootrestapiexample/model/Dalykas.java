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
@Table(name="dalykas")
@EntityListeners(AuditingEntityListener.class)
public class Dalykas {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//private Long dalykoIDIvertinimams;
	
	private Long studentoID;
	
	@NotBlank
	private String pavadinimas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/*public Long getDalykoIDIvertinimams() {
		return dalykoIDIvertinimams;
	}
	
	public void setDalykoIDIvertinimams(Long dalykoIDIvertinimams) {
		this.dalykoIDIvertinimams = dalykoIDIvertinimams;
	}*/

	public Long getStudentoID() {
		return studentoID;
	}

	public void setStudentoID(Long studentoID) {
		this.studentoID = studentoID;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	

}
