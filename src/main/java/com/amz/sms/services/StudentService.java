package com.amz.sms.services;

import java.util.List;
import java.util.Optional;

import com.amz.sms.entities.Student;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudent();
    Optional<Student> getStudentById(String id);
    List<Student> findByStandard(String standard);
    Student findByAdmissionNo(String admNo);

}
