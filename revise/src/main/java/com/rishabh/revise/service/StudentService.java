package com.rishabh.revise.service;

import com.rishabh.revise.dto.StdResponse;

import java.util.List;
import com.rishabh.revise.dto.StdRequest;

public interface StudentService {
    StdResponse createStudent(StdRequest stdRequest);

    List<StdResponse> getAllStudents();

    StdResponse getStudentById(Long id);

    StdResponse updateStudent(Long id,  StdRequest request);

    void deleteStudent(Long id);
}
