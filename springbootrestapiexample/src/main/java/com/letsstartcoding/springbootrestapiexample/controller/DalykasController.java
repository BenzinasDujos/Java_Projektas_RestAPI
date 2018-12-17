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

import com.letsstartcoding.springbootrestapiexample.dao.DalykasDAO;
import com.letsstartcoding.springbootrestapiexample.model.Dalykas;

@RestController
@RequestMapping("/kolegija")
public class DalykasController {
	
	@Autowired
	DalykasDAO dalykasDAO;
	
	/* save Dalykas into DB*/
	@PostMapping("/dalykai")
	public Dalykas createDalykas(@Valid @RequestBody Dalykas dal) {
		return dalykasDAO.save(dal);
	}
	
	/* get all Dalykai*/
	@GetMapping("/dalykai")
	public List<Dalykas> getAllDalykai() {
		return dalykasDAO.findAll();
	}
	
	/*get Dalykas pagal ID*/
	@GetMapping("/dalykai/{id}")
	public ResponseEntity<Dalykas> getDalykasById(@PathVariable(value="id") Long dalid) {
		
		Dalykas dal=dalykasDAO.findAllById(dalid);
		
		if(dal==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dal);
	}
	
	/* update Dalykas by id*/
	@PutMapping("/dalykai/{id}")
	public ResponseEntity<Dalykas> updateDalykas(@PathVariable(value="id") Long dalid,@Valid @RequestBody Dalykas dalDetails) {
		
		Dalykas dal=dalykasDAO.findAllById(dalid);
		if(dal==null) {
			return ResponseEntity.notFound().build();
		}
		//dal.setId(dalDetails.getId());
		dal.setStudentoID(dalDetails.getStudentoID());
		dal.setPavadinimas(dalDetails.getPavadinimas());
		
		Dalykas updateDalykas=dalykasDAO.save(dal);
		return ResponseEntity.ok().body(updateDalykas);
	}
	
	/*Delete Dalykas*/
	@DeleteMapping("/dalykai/{id}")
	public ResponseEntity<Dalykas> deleteDalykas(@PathVariable(value="id") Long dalid) {
		Dalykas dal=dalykasDAO.findAllById(dalid);
		if(dal==null) {
			return ResponseEntity.notFound().build();
		}
		
		dalykasDAO.delete(dal);
		
		return ResponseEntity.ok().build();
	}
}
