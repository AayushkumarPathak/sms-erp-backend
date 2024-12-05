package com.amz.sms.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amz.sms.entities.Student;
import com.amz.sms.repositories.StudentRepo;
import com.amz.sms.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        Optional<Student> student = this.studentRepo.findById(id);
        return student;
    }

    @Override
    public List<Student> findByStandard(String standard) {
        List<Student> students = this.studentRepo.findByStandard(standard);
        return students;

    }

    @Override
    public Student findByAdmissionNo(String admNo) {
        Student student = this.studentRepo.findByAdmissionNo(admNo);
        return student;
    }

    @Override
    public Student updateStudent(String admissionNo, Student studentDto) {
        Student student = this.studentRepo.findById(admissionNo)
                .orElseThrow(() -> new RuntimeException());
        
        student.setName(studentDto.getName());
        student.setSection(studentDto.getSection());
        student.setStandard(studentDto.getStandard());

        return student;

    }

}
