package com.myOrganization.ERPSolution.service.ServiceImpl;

import com.myOrganization.ERPSolution.model.Student;
import com.myOrganization.ERPSolution.repository.StudentRepo;
import com.myOrganization.ERPSolution.service.security.StudentApplication.StudentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentUserDetailsService implements UserDetailsService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepo.findByEmail(email);
        if (student==null){
            throw new RuntimeException("Student Not Exist");
        }

        return new StudentApplication(student);
    }
}
