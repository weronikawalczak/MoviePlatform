package com.example.demo.service.implementation;

import com.example.demo.entity.SystemUser;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.service.AdminService;
import com.example.demo.util.State;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
    private SystemUserRepository systemUserRepository;

    public AdminServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public void banUser(Long userId) {
        try {
            SystemUser user = systemUserRepository.findById(userId).get();
            user.setState(State.BANNED);
            systemUserRepository.save(user);
        }catch (Exception e){
            //TODO new exception userNotFound?
            throw new NullPointerException();
        }
    }

    @Override
    public void activateUser(Long userId) {
        try {
            SystemUser user = systemUserRepository.findById(userId).get();
            user.setState(State.ACTIVE);
            systemUserRepository.save(user);
        }catch (Exception e){
            //TODO new exception userNotFound?
            throw new NullPointerException();
        }
    }
}
