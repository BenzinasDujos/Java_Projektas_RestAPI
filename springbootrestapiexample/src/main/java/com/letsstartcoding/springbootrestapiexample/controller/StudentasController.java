package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.StudentasDAO;
import com.letsstartcoding.springbootrestapiexample.model.Studentas;

@RestController
@RequestMapping("/kolegija")
public class StudentasController {
	
	@Autowired
	StudentasDAO studentasDAO;
	
	/* save Studentas into DB*/
	@PostMapping("/studentai")
	public Studentas createStudentas(@Valid @RequestBody Studentas stud) {
		return studentasDAO.save(stud);
	}
	
	/* get all Studentai*/
	@GetMapping("/studentai")
	public List<Studentas> getAllStudentai() {
		return studentasDAO.findAll();
	}
	
	/*get Studentas pagal ID*/
	@GetMapping("/studentai/{id}")
	public ResponseEntity<Studentas> getStudentasById(@PathVariable(value="id") Long studid) {
		
		Studentas stud=studentasDAO.findOne(studid);
		
		if(stud==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(stud);
	}
	
	/* update Studentas by id*/
	@PutMapping("/studentai/{id}")
	public ResponseEntity<Studentas> updateStudentas(@PathVariable(value="id") Long studid,@Valid @RequestBody Studentas studDetails) {
		
		Studentas stud=studentasDAO.findOne(studid);
		if(stud==null) {
			return ResponseEntity.notFound().build();
		}
		//stud.setId(studDetails.getId());
		stud.setVardas(studDetails.getVardas());
		stud.setPavarde(studDetails.getPavarde());
		stud.setGrupe(studDetails.getGrupe());
		stud.setKursas(studDetails.getKursas());
		
		Studentas updateStudentas=studentasDAO.save(stud);
		return ResponseEntity.ok().body(updateStudentas);
	}
	
	/*Delete Studentas*/
	@DeleteMapping("/studentai/{id}")
	public ResponseEntity<Studentas> deleteStudentas(@PathVariable(value="id") Long studid) {
		Studentas stud=studentasDAO.findOne(studid);
		if(stud==null) {
			return ResponseEntity.notFound().build();
		}
		
		studentasDAO.delete(stud);
		
		return ResponseEntity.ok().build();
	}

}
