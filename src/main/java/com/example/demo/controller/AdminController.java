package com.example.demo.controller;

import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/ban/{userId}")
    public void banUser(@PathVariable(value="userId") Long userId){
        adminService.banUser(userId);
    }

    @PutMapping("/activate/{userId}")
    public void activateUser(@PathVariable(value="userId") Long userId){
        adminService.activateUser(userId);
    }
}
