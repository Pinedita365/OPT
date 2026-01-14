package com.example.ej1_tema5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServicio {
    @Autowired
    private userRepository repo;

    public boolean login(String username, String password) {
        user encontrado = repo.findByUserAndPass(username, password);
        return encontrado != null;
    }
}
