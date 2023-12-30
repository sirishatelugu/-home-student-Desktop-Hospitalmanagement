package com.lifecare.Lifecare.controller;
import com.lifecare.Lifecare.repository.PatientRepository; // Replace DoctorRepository with PatientRepository
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Patient; // Replace Doctor with Patient
import com.lifecare.Lifecare.service.PatientService; // Replace DoctorService with PatientService

@Controller
public class PatientController { // Replace DoctorController with PatientController
    private PatientService patientService; // Replace DoctorService with PatientService

    @Autowired
    public PatientController(PatientService patientService) { // Replace DoctorController with PatientController, DoctorService with PatientService
        super();
        this.patientService = patientService; // Replace doctorService with patientService
    }

    @GetMapping("/patients") // Replace doctors with patients
    public String listPatients(Model model) { // Replace listDoctors with listPatients
        model.addAttribute("patients", patientService.getAllPatient()); // Replace doctors with patients
        return "patients"; // Replace doctors with patients
    }

    @GetMapping("/patients/new") // Replace doctors with patients
    public String createPatient(Model model) { // Replace createDoctor with createPatient
        // create patient object to hold patient form data
        Patient patient = new Patient(); // Replace Doctor with Patient
        model.addAttribute("patients", patient); // Replace doctors with patients
        return "createpatient"; // Replace createdoctor with createpatient
    }

    @PostMapping("/patients") // Replace doctors with patients
    public String savePatient(@ModelAttribute("patient") Patient patient) { // Replace saveDoctor with savePatient, Doctor with Patient
        patientService.savePatient(patient); // Replace doctorService with patientService
        return "redirect:/patients"; // Replace doctors with patients
    }

    @GetMapping("/patients/edit/{id}") // Replace doctors with patients
    public String editPatientForm(@PathVariable Long id, Model model) { // Replace editDoctorForm with editPatientForm, Doctor with Patient
        model.addAttribute("patient", patientService.getPatientById(id)); // Replace doctorService with patientService, Doctor with Patient
        return "editpatient"; // Replace editdoctor with editpatient
    }

    @PostMapping("/patients/{id}") // Replace doctors with patients
    public String updatePatient(@PathVariable Long id,
                                @ModelAttribute("patient") Patient patient,
                                Model model) {
        // get patient from database by id
        Patient existingPatient = patientService.getPatientById(id);
        existingPatient.setId(id);
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setMobileno(patient.getMobileno());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setHealthIssue(patient.getHealthIssue());

        // save updated patient object
        patientService.updatePatient(existingPatient);
        return "redirect:/patients"; // Replace doctors with patients
    }

    @GetMapping("/patients/{id}") // Replace doctors with patients
    public String deletePatient(@PathVariable Long id) { // Replace deleteDoctor with deletePatient
        patientService.deletePatientById(id); // Replace doctorService with patientService
        return "redirect:/patients"; // Replace doctors with patients
    }

    @Autowired
    private PatientRepository patientRepository; // Replace DoctorRepository with PatientRepository

    @GetMapping("/searchs")
    public String searchPage() {
        return "searchs";
    }

    @GetMapping("/patientdetails")
    public String detailsPage(@RequestParam Long id, Model model) {
        Patient entity = patientRepository.findById(id).orElse(null); // Replace Doctor with Patient
        model.addAttribute("entity", entity);
        return "patientdetails";
    }

  
}

