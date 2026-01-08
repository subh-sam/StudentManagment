package com.myOrganization.ERPSolution.repository;

import com.myOrganization.ERPSolution.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {
 Optional<Student> findByStudentIdAndStudentClass(Long studentId,Integer studentClass);
    @Query(value = "Select * from student where student_id =:id",nativeQuery = true)
    Student findStudent(@Param("id") Long id);

    @Query(value = "select * from student where student_class =:studentClass",nativeQuery = true)
    List<Student> findStudentByClass(@Param("studentClass") Integer studentClass);

    Student findByEmail(String email);

}
