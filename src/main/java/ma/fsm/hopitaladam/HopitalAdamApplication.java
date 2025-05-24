package ma.fsm.hopitaladam;

import ma.fsm.hopitaladam.entities.Patient;
import ma.fsm.hopitaladam.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalAdamApplication implements CommandLineRunner{
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HopitalAdamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setId(null);
        patient.setDateNaissance(new Date());
        patient.setMalade(true);
        patient.setScore(320);
        patient.setNom("adam");
//using builder
        Patient patient2 = Patient.builder()
                .nom("aziz")
                .score(111)
                .malade(false)
                .dateNaissance(new Date())
                .id(null)
                .build();
        patientRepository.save(patient);
        patientRepository.save(patient2);
    }
}
