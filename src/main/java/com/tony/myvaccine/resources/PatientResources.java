package com.tony.myvaccine.resources;

import com.tony.myvaccine.domain.Patient;
import com.tony.myvaccine.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientResources {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {

        return patientRepository.findById(id).map(
                x -> {
                    x.setCpf(patient.getName());
                    x.setCpf(patient.getCpf());
                    x.setCpf(patient.getAge());
                    x.setCpf(patient.getBirthDate());
                    x.setCpf(patient.getPhone());
                    x.setCpf(patient.getEmail());

                    Patient updatePatient = patientRepository.save(patient);

                    return ResponseEntity.ok().body(updatePatient);
                }
        ).orElse(ResponseEntity.notFound().build());
    }
}
