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

import com.letsstartcoding.springbootrestapiexample.dao.IvertinimasDAO;
import com.letsstartcoding.springbootrestapiexample.model.Ivertinimas;

@RestController
@RequestMapping("/kolegija")
public class IvertinimasController {
	
	@Autowired
	IvertinimasDAO ivertinimasDAO;
	
	/*save Ivertinimas into DB*/
	@PostMapping("/ivertinimai")
	public Ivertinimas createIvertinimas(@Valid @RequestBody Ivertinimas ivert) {
		return ivertinimasDAO.save(ivert);
	}
	
	/* get all Ivertinimai*/
	@GetMapping("/ivertinimai")
	public List<Ivertinimas> getAllIvertinimai() {
		return ivertinimasDAO.findAll();
	}
	
	/*get Ivertinimas pagal ID*/
	@GetMapping("/ivertinimai/{id}")
	public ResponseEntity<Ivertinimas> getIvertinimasById(@PathVariable(value="id") Long ivertid) {
		
		Ivertinimas ivert=ivertinimasDAO.findAllById(ivertid);
		
		if(ivert==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ivert);
	}
	
	/* update Ivertinimas by id*/
	@PutMapping("/ivertinimai/{id}")
	public ResponseEntity<Ivertinimas> updateIvertinimas(@PathVariable(value="id") Long ivertid,@Valid @RequestBody Ivertinimas ivertDetails) {
		
		Ivertinimas ivert=ivertinimasDAO.findAllById(ivertid);
		if(ivert==null) {
			return ResponseEntity.notFound().build();
		}
		//ivert.setId(ivertDetails.getId());
		ivert.setDalykoID(ivertDetails.getDalykoID());
		ivert.setTipas(ivertDetails.getTipas());
		ivert.setIvertinimas(ivertDetails.getIvertinimas());
		ivert.setDalykoPavadinimas(ivertDetails.getDalykoPavadinimas());
		ivert.setStudentoooID(ivertDetails.getStudentoooID());
		
		Ivertinimas updateIvertinimas=ivertinimasDAO.save(ivert);
		return ResponseEntity.ok().body(updateIvertinimas);
	}
	
	/*Delete Ivertinimas*/
	@DeleteMapping("/ivertinimai/{id}")
	public ResponseEntity<Ivertinimas> deleteIvertinimas(@PathVariable(value="id") Long ivertid) {
		Ivertinimas ivert=ivertinimasDAO.findAllById(ivertid);
		if(ivert==null) {
			return ResponseEntity.notFound().build();
		}
		
		ivertinimasDAO.delete(ivert);
		
		return ResponseEntity.ok().build();
	}

}
