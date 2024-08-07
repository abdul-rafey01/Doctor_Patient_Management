package com.example.Doctor_Patient_Management.Service;

import com.example.Doctor_Patient_Management.GlobalExceptionHandler;
import com.example.Doctor_Patient_Management.entity.Doctor;
import com.example.Doctor_Patient_Management.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        doctor.setId(UUID.randomUUID().toString());
        if (doctor.getName().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Doctor Name is not provided : ");
        }
        if (doctor.getSpecialization().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Doctor Specialization is not provided : ");
        }
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctor(String id, Doctor doctor) {
        doctor.setId(UUID.randomUUID().toString());
        if (doctor.getName().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Doctor Name is not provided : ");
        }
        if (doctor.getSpecialization().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Doctor Specialization is not provided : ");
        }
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }
}