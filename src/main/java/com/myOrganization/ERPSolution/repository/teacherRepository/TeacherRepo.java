package com.myOrganization.ERPSolution.repository.teacherRepository;

import com.myOrganization.ERPSolution.model.teacher.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {

    @Query(value = "select * from teacher where name =:name || id =:id" , nativeQuery = true)
    Teacher getTeacher(@Param("name") String name,@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from teacher where id =:id" ,nativeQuery = true)
    int removeTeacher(@Param("id") Long id);
}
