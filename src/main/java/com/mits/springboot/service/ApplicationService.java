package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.Application;
import com.mits.springboot.entity.Status;
import com.mits.springboot.repo.ApplicationRepo;

@Service
public class ApplicationService {
	private ApplicationRepo repo;

	@Autowired
	public ApplicationService(ApplicationRepo repo) {
		this.repo = repo;
	}

	public Application insertOrUpdate(Application application) {
		return repo.save(application);
	}

	public List<Application> insertAll(List<Application> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public Application getOne(String id) {
		return repo.getOne(id);
	}

	public List<Application> getAll() {
		return repo.findAll();
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	public Integer getApplicationId() {
		return null;
	}
	public List<Application> getByStatus(Status status){
		return repo.findByStatus(status);
	}

}
