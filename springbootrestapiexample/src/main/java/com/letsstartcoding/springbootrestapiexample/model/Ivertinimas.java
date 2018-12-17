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
@Table(name="ivertinimas")
@EntityListeners(AuditingEntityListener.class)
public class Ivertinimas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long dalykoID;
	
	private Long studentoooID;
	
	@NotBlank
	private String tipas;
	
	@NotBlank
	private String dalykoPavadinimas;
	
	private Long ivertinimas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDalykoID() {
		return dalykoID;
	}

	public void setDalykoID(Long dalykoID) {
		this.dalykoID = dalykoID;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public Long getIvertinimas() {
		return ivertinimas;
	}

	public void setIvertinimas(Long ivertinimas) {
		this.ivertinimas = ivertinimas;
	}

	public String getDalykoPavadinimas() {
		return dalykoPavadinimas;
	}

	public void setDalykoPavadinimas(String dalykoPavadinimas) {
		this.dalykoPavadinimas = dalykoPavadinimas;
	}

	public Long getStudentoooID() {
		return studentoooID;
	}

	public void setStudentoooID(Long studentoooID) {
		this.studentoooID = studentoooID;
	}
	
	
	

}
