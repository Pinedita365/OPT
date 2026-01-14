package com.example.ej1_tema5;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository <user, Long>{
    user findByUserAndPass(String user, String pass);
}
