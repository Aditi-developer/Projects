package com.example.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.FormDataModel;

@Repository
public interface SchoolDBRepository extends
CrudRepository<FormDataModel, Long>{

}
