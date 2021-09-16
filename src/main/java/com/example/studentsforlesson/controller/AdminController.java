package com.example.studentsforlesson.controller;

import com.example.studentsforlesson.Service.StudentService;
import com.example.studentsforlesson.entity.Students;
import com.example.studentsforlesson.payload.StudentPayload;
import com.example.studentsforlesson.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AdminController {
  private final StudentService studentService;
  private final StudentRepository studentRepository;

  public AdminController(StudentService studentService, StudentRepository studentRepository) {
    this.studentService = studentService;
    this.studentRepository = studentRepository;
  }



  @PostMapping("/student/add")
  private ResponseEntity save(@RequestBody StudentPayload studentPayload) {
    return studentService.addUser(studentPayload) ? ResponseEntity.ok("Qo'shildi") : new ResponseEntity("Xatolik", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @GetMapping("/student/get")
  private ResponseEntity getStudents() {
    return ResponseEntity.ok(studentRepository.findAll());
  }

  @DeleteMapping("/student/delete/{id}")
  private ResponseEntity deleteStudent(@PathVariable Long id) {
    return studentService.deleteStudent(id) ? ResponseEntity.ok("O'chirildi") : new ResponseEntity("Xatolik", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @PostMapping("/student/update/{id}")
  private ResponseEntity update(@PathVariable Long id, @RequestBody Students students) {
    Optional<Students> user1 = studentRepository.findById(id);
    if (students != null) {
      students.setId(id);
      studentRepository.save(students);
      return ResponseEntity.ok("Yaratildi");
    } else {
      return (ResponseEntity) ResponseEntity.notFound();
    }
  }


}
