package com.lifecare.Lifecare.controller;
import com.lifecare.Lifecare.repository.AppointmentRepository; // Replace StaffRepository with AppointmentRepository
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Appointment; // Replace Staff with Appointment
import com.lifecare.Lifecare.service.AppointmentService; // Replace StaffService with AppointmentService

@Controller
public class AppointmentController { // Replace StaffController with AppointmentController
    private AppointmentService appointmentService; // Replace StaffService with AppointmentService

    @Autowired
    public AppointmentController(AppointmentService appointmentService) { // Replace StaffController with AppointmentController, StaffService with AppointmentService
        super();
        this.appointmentService = appointmentService; // Replace staffService with appointmentService
    }

    @GetMapping("/appointment") // Replace staff with appointment
    public String listAppointments(Model model) { // Replace listStaff with listAppointments
        model.addAttribute("appointments", appointmentService.getAllAppointments()); // Replace staff with appointment
        return "appointment"; // Replace staff with appointment
    }
}
