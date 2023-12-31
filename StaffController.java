package com.lifecare.Lifecare.controller;

import com.lifecare.Lifecare.repository.StaffRepository; 
import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lifecare.Lifecare.entity.Staff; 
import com.lifecare.Lifecare.service.StaffService; 

@Controller
public class StaffController { 
    private StaffService staffService; 

    @Autowired
    public StaffController(StaffService staffService) {  
        super();
        this.staffService = staffService;
    }

    @GetMapping("/staff") 
    public String listStaff(Model model) { 
        model.addAttribute("staff", staffService.getAllStaff());
        return "staff"; 
    }

    @GetMapping("/staff/new") 
    public String createStaff(Model model) { 
      
        Staff staff = new Staff(); 
        model.addAttribute("staff", staff);
        return "createstaff"; 
    }

    @PostMapping("/staff") 
    public String saveStaff(@ModelAttribute("staff") Staff staff) { 
        staffService.saveStaff(staff); 
        return "redirect:/staff"; 
    }

    @GetMapping("/staff/edit/{id}") 
    public String editStaffForm(@PathVariable Long id, Model model) { 
        model.addAttribute("staff", staffService.getStaffById(id));
        return "editstaff"; 
    }

    @PostMapping("/staff/{id}") 
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
        return "redirect:/staff"; 
    }

    @GetMapping("/staff/{id}") 
    public String deleteStaff(@PathVariable Long id) { 
        staffService.deleteStaffById(id);
        return "redirect:/staff"; 

    @Autowired
    private StaffRepository staffRepository; 

    @GetMapping("/searchpage")
    public String searchPage() {
        return "searchpage";
    }

    @GetMapping("/staffdetails")
    public String detailsPage(@RequestParam Long id, Model model) {
        Staff entity = staffRepository.findById(id).orElse(null);
        model.addAttribute("entity", entity);
        return "staffdetails";
    }


}

