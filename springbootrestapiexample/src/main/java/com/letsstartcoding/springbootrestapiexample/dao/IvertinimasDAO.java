package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Ivertinimas;
import com.letsstartcoding.springbootrestapiexample.repository.IvertinimasRepository;

@Service
public class IvertinimasDAO {
	
	@Autowired
	IvertinimasRepository ivertinimasRepository;
	
	/*save Ivertinimas*/
	public Ivertinimas save(Ivertinimas ivert) {
		return ivertinimasRepository.save(ivert);
	}
	
	/*rasti visus Ivertinimus*/
	public List<Ivertinimas> findAll() {
		return ivertinimasRepository.findAll();
	}
	
	/*rasti Ivertinima pagal ID*/
	public Ivertinimas findAllById(Long ivertid) {
		return ivertinimasRepository.findOne(ivertid);
	}
	
	/*istrinti Ivertinima*/
	public void delete(Ivertinimas ivert) {
		ivertinimasRepository.delete(ivert);
	}

}
