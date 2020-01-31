package com.example.demo.repositories;

import com.example.demo.models.Faculty;

import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty,Integer> {
}
