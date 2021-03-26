package com.tony.myvaccine.services;

import com.tony.myvaccine.domain.Patient;
import com.tony.myvaccine.domain.PriorityGroups;
import com.tony.myvaccine.repository.PatientRepository;
import com.tony.myvaccine.repository.PriorityGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PriorityGroupsRepository priorityGroupsRepository;

    // add
    public Patient savePatient(Patient patient) {
        Patient patientExists = patientRepository.findByEmail(patient.getEmail());

        if (patientExists != null && !patientExists.equals(patient)) {
            throw new RuntimeException("Errro de Service do Karalhoooo!!!");
        }

        return patientRepository.save(patient);
    }

    // remove
    public void removePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
