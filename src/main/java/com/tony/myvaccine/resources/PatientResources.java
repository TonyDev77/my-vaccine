package com.tony.myvaccine.resources;

import com.tony.myvaccine.domain.Patient;
import com.tony.myvaccine.repository.PatientRepository;
import com.tony.myvaccine.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientResources {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> findById(@PathVariable Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{idPatient}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long idPatient, @RequestBody Patient patient) {

        if (!patientRepository.existsById(idPatient)) {
            return ResponseEntity.notFound().build();
        }
        patient.setId(idPatient);
        patient = patientService.savePatient(patient);

        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") Long id) {
        if (!patientRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }

        patientService.removePatient(id);

        return ResponseEntity.noContent().build();
    }
}
