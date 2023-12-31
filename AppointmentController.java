package com.lifecare.Lifecare.controller;
import com.lifecare.Lifecare.repository.AppointmentRepository; 
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Appointment; 
import com.lifecare.Lifecare.service.AppointmentService; 

@Controller
public class AppointmentController { 
    private AppointmentService appointmentService; 

    @Autowired
    public AppointmentController(AppointmentService appointmentService) { 
        super();
        this.appointmentService = appointmentService; 
    }

    @GetMapping("/appointment")
    public String listAppointments(Model model) { 
        model.addAttribute("appointments", appointmentService.getAllAppointments()); 
        return "appointment"; 
    }
}
