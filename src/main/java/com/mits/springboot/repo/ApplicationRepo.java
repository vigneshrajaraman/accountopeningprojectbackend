package com.mits.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.Application;
import com.mits.springboot.entity.Status;

public interface ApplicationRepo extends JpaRepository<Application, String> {
//@Query("select application_seq.nextval from dual")
//Integer getApplicationId();
	List<Application> findByStatus(Status status);
}
