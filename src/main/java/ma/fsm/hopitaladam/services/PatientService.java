package ma.fsm.hopitaladam.services;

import ma.fsm.hopitaladam.entities.Patient;
import ma.fsm.hopitaladam.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        System.out.println("Patient saved : " + patient);
        return patientRepository.save(patient);
    }

    public Page<Patient> getAllPatients(String word, int page, int size) {
        return patientRepository.findByNomContains(word, PageRequest.of(page, size));
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}