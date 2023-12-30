package com.lifecare.Lifecare.controller;

import com.lifecare.Lifecare.repository.DoctorRepository;
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Doctor;
import com.lifecare.Lifecare.service.DoctorService;
import org.springframework.ui.Model;

@Controller
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        super();
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctor());
        return "doctors";
    }

    @GetMapping("/doctors/new")
    public String createDoctor(Model model) {
        // create doctor object to hold doctor form data
        Doctor doctor = new Doctor();
        model.addAttribute("doctors", doctor);
        return "createdoctor";
    }

    @PostMapping("/doctors")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/edit/{id}")
    public String editDoctorForm(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "editdoctor";
    }

    @PostMapping("/doctors/{id}")
    public String updateDoctor(@PathVariable Long id,
                               @ModelAttribute("doctor") Doctor doctor,
                               Model model) {

        // get doctor from database by id
        Doctor existingDoctor = doctorService.getDoctorById(id);
        existingDoctor.setId(id);
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setAge(doctor.getAge());
        existingDoctor.setGender(doctor.getGender());
        existingDoctor.setMobileno(doctor.getMobileno());
        existingDoctor.setAddress(doctor.getAddress());
        existingDoctor.setSpecialization(doctor.getSpecialization());

        // save updated doctor object
        doctorService.updateDoctor(existingDoctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }

    @GetMapping("/details")
    public String detailsPage(@RequestParam Long id, Model model) {
        Doctor entity = doctorRepository.findById(id).orElse(null);
        model.addAttribute("entity", entity);
        return "details";
    }

    @GetMapping("/medicine")
    public String showMedicinePage() {
        return "medicine"; // This should match the name of your HTML file (without the extension)
    }
}

