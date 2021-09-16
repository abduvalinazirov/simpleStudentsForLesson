package com.example.studentsforlesson.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentPayload {
  private String firstname;
  private String lastname;
  private String username;
  private String phoneNumber;
}
