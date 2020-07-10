package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.Application;

public interface ApplicationRepo extends JpaRepository<Application, String> {

}
