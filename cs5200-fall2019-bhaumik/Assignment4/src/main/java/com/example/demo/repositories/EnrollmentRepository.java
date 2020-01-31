package com.example.demo.repositories;

import com.example.demo.models.CompositeId;
import com.example.demo.models.Enrollment;
import com.example.demo.models.Faculty;

import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, CompositeId> {
}

