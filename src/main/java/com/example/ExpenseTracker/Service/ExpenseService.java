package com.example.ExpenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExpenseTracker.PathModel.ExpenseModel;
import com.example.ExpenseTracker.Repositary.ExpenseRepositary;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepositary repo;
	
	public List<ExpenseModel> listAll()
	{
		return repo.findAll();
	}
	public void save(ExpenseModel expense) {
		repo.save(expense);
	}
	public ExpenseModel get(Long id) {
		return repo.findById(id).orElse(null);
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public void deleteAll() {
		// TODO Auto-generated method stub
		 repo.deleteAll();
	}
	
}
