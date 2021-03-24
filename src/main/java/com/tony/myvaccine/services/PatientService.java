package com.tony.myvaccine.services;

import com.tony.myvaccine.domain.Patient;
import com.tony.myvaccine.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // add
    public Patient savePatient(Patient patient) {

        Patient patientExists = patientRepository.findByEmail(patient.getEmail());

        if (patientExists != null && patientExists.equals(patient)) {
            throw new NullPointerException("Já existe um cliente cadastrado com esse email!");
        }
        return patientRepository.save(patient);
    }

    // remove
    public void removePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
