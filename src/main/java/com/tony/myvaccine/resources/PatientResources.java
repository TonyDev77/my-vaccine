package com.tony.myvaccine.resources;

import com.tony.myvaccine.domain.Patient;
import com.tony.myvaccine.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientResources {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
