package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mits.springboot.entity.Application;

public interface ApplicationRepo extends JpaRepository<Application, String> {
//@Query("select application_seq.nextval from dual")
//Integer getApplicationId();
}
