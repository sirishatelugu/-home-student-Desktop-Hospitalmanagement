package com.lifecare.Lifecare.controller;

import com.lifecare.Lifecare.repository.StaffRepository; // Replace PatientRepository with StaffRepository
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Staff; // Replace Patient with Staff
import com.lifecare.Lifecare.service.StaffService; // Replace PatientService with StaffService

@Controller
public class StaffController { // Replace PatientController with StaffController
    private StaffService staffService; // Replace PatientService with StaffService

    @Autowired
    public StaffController(StaffService staffService) { // Replace PatientController with StaffController, PatientService with StaffService
        super();
        this.staffService = staffService; // Replace patientService with staffService
    }

    @GetMapping("/staff") // Replace patients with staff
    public String listStaff(Model model) { // Replace listPatients with listStaff
        model.addAttribute("staff", staffService.getAllStaff()); // Replace patients with staff
        return "staff"; // Replace patients with staff
    }

    @GetMapping("/staff/new") // Replace patients with staff
    public String createStaff(Model model) { // Replace createPatient with createStaff
        // create staff object to hold staff form data
        Staff staff = new Staff(); // Replace Patient with Staff
        model.addAttribute("staff", staff); // Replace patients with staff
        return "createstaff"; // Replace createpatient with createstaff
    }

    @PostMapping("/staff") // Replace patients with staff
    public String saveStaff(@ModelAttribute("staff") Staff staff) { // Replace savePatient with saveStaff, Patient with Staff
        staffService.saveStaff(staff); // Replace patientService with staffService
        return "redirect:/staff"; // Replace patients with staff
    }

    @GetMapping("/staff/edit/{id}") // Replace patients with staff
    public String editStaffForm(@PathVariable Long id, Model model) { // Replace editPatientForm with editStaffForm, Patient with Staff
        model.addAttribute("staff", staffService.getStaffById(id)); // Replace patientService with staffService, Patient with Staff
        return "editstaff"; // Replace editpatient with editstaff
    }

    @PostMapping("/staff/{id}") // Replace patients with staff
    public String updateStaff(@PathVariable Long id,
                                @ModelAttribute("staff") Staff staff,
                                Model model) {
        // get staff from database by id
        Staff existingStaff = staffService.getStaffById(id);
        existingStaff.setId(id);
        existingStaff.setName(staff.getName());
        existingStaff.setAge(staff.getAge());
        existingStaff.setGender(staff.getGender());
        existingStaff.setMobileNo(staff.getMobileNo());
        existingStaff.setAddress(staff.getAddress());
        existingStaff.setDepartment(staff.getDepartment());

        // save updated staff object
        staffService.updateStaff(existingStaff);
        return "redirect:/staff"; // Replace patients with staff
    }

    @GetMapping("/staff/{id}") // Replace patients with staff
    public String deleteStaff(@PathVariable Long id) { // Replace deletePatient with deleteStaff
        staffService.deleteStaffById(id); // Replace patientService with staffService
        return "redirect:/staff"; // Replace patients with staff
    }

    @Autowired
    private StaffRepository staffRepository; // Replace PatientRepository with StaffRepository

    @GetMapping("/searchpage")
    public String searchPage() {
        return "searchpage";
    }

    @GetMapping("/staffdetails")
    public String detailsPage(@RequestParam Long id, Model model) {
        Staff entity = staffRepository.findById(id).orElse(null); // Replace Patient with Staff
        model.addAttribute("entity", entity);
        return "staffdetails";
    }


}

