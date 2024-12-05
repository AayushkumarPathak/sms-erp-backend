package com.amz.sms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amz.sms.entities.Student;

public interface StudentRepo extends JpaRepository<Student,String> {
    List<Student> findByStandard(String standard);
    Student findByAdmissionNo(String admNo);
}
