package com.example.Doctor_Patient_Management.Repository;

import com.example.Doctor_Patient_Management.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByDoctorId(String doctorId);
}