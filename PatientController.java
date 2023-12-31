package com.lifecare.Lifecare.controller;
import com.lifecare.Lifecare.repository.PatientRepository; 
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Patient; 
import com.lifecare.Lifecare.service.PatientService; 

@Controller
public class PatientController { 
    private PatientService patientService; 

    @Autowired
    public PatientController(PatientService patientService) { 
        super();
        this.patientService = patientService; 
    }

    @GetMapping("/patients") 
    public String listPatients(Model model) { 
        model.addAttribute("patients", patientService.getAllPatient()); 
        return "patients"; 
    }

    @GetMapping("/patients/new") 
    public String createPatient(Model model) { 
        // create patient object to hold patient form data
        Patient patient = new Patient(); 
        model.addAttribute("patients", patient); 
        return "createpatient";
    }

    @PostMapping("/patients") 
    public String savePatient(@ModelAttribute("patient") Patient patient) { 
        patientService.savePatient(patient); 
        return "redirect:/patients"; 
    }

    @GetMapping("/patients/edit/{id}") 
    public String editPatientForm(@PathVariable Long id, Model model) { 
        model.addAttribute("patient", patientService.getPatientById(id)); 
        return "editpatient"; 
    }

    @PostMapping("/patients/{id}") 
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
        return "redirect:/patients"; 
    }

    @GetMapping("/patients/{id}") 
    public String deletePatient(@PathVariable Long id) { 
        patientService.deletePatientById(id);
        return "redirect:/patients"; 
    }

    @Autowired
    private PatientRepository patientRepository; 

    @GetMapping("/searchs")
    public String searchPage() {
        return "searchs";
    }

    @GetMapping("/patientdetails")
    public String detailsPage(@RequestParam Long id, Model model) {
        Patient entity = patientRepository.findById(id).orElse(null);
        model.addAttribute("entity", entity);
        return "patientdetails";
    }

  
}

