package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Dalykas;
import com.letsstartcoding.springbootrestapiexample.repository.DalykasRepository;

@Service
public class DalykasDAO {
	
	@Autowired
	DalykasRepository dalykasRepository;
	
	/* save Dalykas*/
	public Dalykas save(Dalykas dal) {
		return dalykasRepository.save(dal);
	}
	
	/* rasti visus Dalykus*/
	public List<Dalykas> findAll() {
		return dalykasRepository.findAll();
	}
	
	/*Select all dalykas pagal studentoID*/
	/*Find dalykas pagal ID*/
	public Dalykas findAllById(Long dalid) {
		return dalykasRepository.findOne(dalid);
	}
	
	/*Istrinti dalyka*/
	public void delete(Dalykas dal) {
		dalykasRepository.delete(dal);
	}

}
