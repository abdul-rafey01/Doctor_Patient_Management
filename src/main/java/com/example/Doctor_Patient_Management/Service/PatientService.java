package com.example.Doctor_Patient_Management.Service;

import com.example.Doctor_Patient_Management.GlobalExceptionHandler;
import com.example.Doctor_Patient_Management.entity.Patient;
import com.example.Doctor_Patient_Management.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        if (patient.getName().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Patient Name is not provided : ");
        }
        if (patient.getAge()<= 0){
            throw new GlobalExceptionHandler.InvalidFieldException("Patient Age is invalid : ");
        }
        if (patient.getDoctorId().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException(" please provide the doctor id: ");
        }

        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public Patient updatePatient(String id, Patient patient) {
        patient.setId(id);
        if (patient.getName().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Patient Name is not provided : ");
        }
        if (patient.getAge()<= 0){
            throw new GlobalExceptionHandler.InvalidFieldException("Patient Age is invalid : ");
        }
        if (patient.getDoctorId().isEmpty()){
            throw new GlobalExceptionHandler.InvalidFieldException("Please provide the doctor id: ");
        }
        return patientRepository.save(patient);
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> getPatientsByDoctorId(String doctorId) {
        return patientRepository.findByDoctorId(doctorId);
    }
}