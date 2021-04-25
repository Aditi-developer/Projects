package com.example.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.ContactUsModel;

@Repository
public interface ContactUsRepository extends CrudRepository<ContactUsModel, Long> {

}
