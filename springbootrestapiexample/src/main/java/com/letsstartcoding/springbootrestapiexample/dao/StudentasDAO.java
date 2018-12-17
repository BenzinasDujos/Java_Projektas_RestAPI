package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Studentas;
import com.letsstartcoding.springbootrestapiexample.repository.StudentasRepository;

@Service
public class StudentasDAO {
	
	
	@Autowired
	StudentasRepository studentasRepository;
	
	/*to save an Studentas*/
	
	public Studentas save(Studentas stud) {
		return studentasRepository.save(stud);
	}
	
	/*surasti visus Studentus*/
	
	public List<Studentas> findAll() {
		return studentasRepository.findAll();
	}
	
	/*get an Studentas by id*/
	
	public Studentas findOne(Long studid) {
		return studentasRepository.findOne(studid);
	}
	
	/*istrinti Studenta*/
	
	public void delete(Studentas stud) {
		studentasRepository.delete(stud);
	}
}
