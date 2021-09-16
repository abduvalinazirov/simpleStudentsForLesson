package com.example.studentsforlesson.Service;

import com.example.studentsforlesson.entity.Students;
import com.example.studentsforlesson.payload.StudentPayload;
import com.example.studentsforlesson.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;

  public boolean addUser(StudentPayload studentPayload) {
    Students students = new Students();
    students.setFirstname(studentPayload.getFirstname());
    students.setLastname(studentPayload.getLastname());
    students.setUsername(studentPayload.getUsername());
    students.setPhoneNumber(studentPayload.getPhoneNumber());
    return studentRepository.save(students) != null;
  }

  public boolean deleteStudent(Long id) {
    Optional<Students> students = studentRepository.findById(id);
    try {
      studentRepository.delete(students.get());
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
