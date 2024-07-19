package com.example.Doctor_Patient_Management.Repository;

import com.example.Doctor_Patient_Management.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}