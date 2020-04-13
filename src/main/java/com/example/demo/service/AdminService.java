package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    void banUser(Long userId);
    void activateUser(Long userId);
}
