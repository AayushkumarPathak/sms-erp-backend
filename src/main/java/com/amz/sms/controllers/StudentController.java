package com.amz.sms.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amz.sms.entities.Student;
import com.amz.sms.services.StudentService;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student savedStudent = this.studentService.addStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = this.studentService.getAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable String id) {
        Optional<Student> student = this.studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping("/search/standard/{standard}")
    public ResponseEntity<List<Student>> findStudentsByStandard(@PathVariable String standard){
        List<Student> students = this.studentService.findByStandard(standard);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/search/admissionNo/{admNo}")
    public ResponseEntity<Student> findByAdmissionNo(@PathVariable String admNo){
        Student student = this.studentService.findByAdmissionNo(admNo);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

}
