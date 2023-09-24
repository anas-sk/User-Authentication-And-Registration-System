package com.example.RegisterLogin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.RegisterLogin.Entity.Employee;

//@EnableJpaRepositories
@Repository
public interface Employee_Repository extends JpaRepository<Employee, Long> {
	boolean existsByEmail(String email);
	Optional<Employee> findOneByEmailAndPassword(String email,String password);
	Employee findByEmail(String email);
}
