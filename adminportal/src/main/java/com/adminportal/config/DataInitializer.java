package com.adminportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adminportal.domain.Doctor;
import com.adminportal.domain.Disease;
import com.adminportal.service.DoctorService;
import com.adminportal.service.DiseaseService;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private DiseaseService diseaseService;

    @Override
    public void run(String... args) throws Exception {
        initializeDoctors();
        initializeDiseases();
    }

    private void initializeDoctors() {
        // Check if doctors already exist
        if (doctorService.findAll().isEmpty()) {
            // Create predefined doctors
            Doctor doctor1 = new Doctor();
            doctor1.setDoctorName("Dr. John Smith");
            doctor1.setSpecialization("Cardiology");
            doctor1.setEmail("john.smith@hospital.com");
            doctor1.setPhoneNumber("+1-555-0101");
            doctor1.setActive(true);
            doctorService.save(doctor1);

            Doctor doctor2 = new Doctor();
            doctor2.setDoctorName("Dr. Emily Johnson");
            doctor2.setSpecialization("Neurology");
            doctor2.setEmail("emily.johnson@hospital.com");
            doctor2.setPhoneNumber("+1-555-0102");
            doctor2.setActive(true);
            doctorService.save(doctor2);

            Doctor doctor3 = new Doctor();
            doctor3.setDoctorName("Dr. Michael Brown");
            doctor3.setSpecialization("Orthopedics");
            doctor3.setEmail("michael.brown@hospital.com");
            doctor3.setPhoneNumber("+1-555-0103");
            doctor3.setActive(true);
            doctorService.save(doctor3);

            Doctor doctor4 = new Doctor();
            doctor4.setDoctorName("Dr. Sarah Davis");
            doctor4.setSpecialization("Pediatrics");
            doctor4.setEmail("sarah.davis@hospital.com");
            doctor4.setPhoneNumber("+1-555-0104");
            doctor4.setActive(true);
            doctorService.save(doctor4);

            Doctor doctor5 = new Doctor();
            doctor5.setDoctorName("Dr. Robert Wilson");
            doctor5.setSpecialization("General Medicine");
            doctor5.setEmail("robert.wilson@hospital.com");
            doctor5.setPhoneNumber("+1-555-0105");
            doctor5.setActive(true);
            doctorService.save(doctor5);

            Doctor doctor6 = new Doctor();
            doctor6.setDoctorName("Dr. Lisa Anderson");
            doctor6.setSpecialization("Dermatology");
            doctor6.setEmail("lisa.anderson@hospital.com");
            doctor6.setPhoneNumber("+1-555-0106");
            doctor6.setActive(true);
            doctorService.save(doctor6);

            System.out.println("✅ Predefined doctors initialized successfully!");
        } else {
            System.out.println("✅ Doctors already exist in database");
        }
    }

    private void initializeDiseases() {
        // Check if diseases already exist
        if (diseaseService.findAll().isEmpty()) {
            Disease disease1 = new Disease();
            disease1.setDiseasetype("Hypertension");
            diseaseService.save(disease1);

            Disease disease2 = new Disease();
            disease2.setDiseasetype("Diabetes");
            diseaseService.save(disease2);

            Disease disease3 = new Disease();
            disease3.setDiseasetype("Asthma");
            diseaseService.save(disease3);

            Disease disease4 = new Disease();
            disease4.setDiseasetype("Heart Disease");
            diseaseService.save(disease4);

            Disease disease5 = new Disease();
            disease5.setDiseasetype("Arthritis");
            diseaseService.save(disease5);

            System.out.println("✅ Predefined diseases initialized successfully!");
        } else {
            System.out.println("✅ Diseases already exist in database");
        }
    }
}
