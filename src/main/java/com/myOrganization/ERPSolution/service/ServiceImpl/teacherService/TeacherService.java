package com.myOrganization.ERPSolution.service.ServiceImpl.teacherService;

import com.myOrganization.ERPSolution.dto.teacherDto.TeacherRequest;
import com.myOrganization.ERPSolution.dto.teacherDto.TeacherResponse;
import com.myOrganization.ERPSolution.model.teacher.Teacher;
import com.myOrganization.ERPSolution.repository.teacherRepository.TeacherRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepo teacherRepo;
    public TeacherResponse registration (TeacherRequest teacherRequest){
        Teacher teacher = new Teacher();
        teacher.setName(teacherRequest.getName());
        teacher.setPhone(teacherRequest.getPhone());
        teacher.setPassword(teacherRequest.getPassword());

        teacher = teacherRepo.save(teacher);

        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setPhone(teacher.getPhone());
        teacherResponse.setPassword(teacher.getPassword());
        return teacherResponse;
    }

    public TeacherResponse getUser(String name, Long id){
        Teacher teacher = teacherRepo.getTeacher(name , id);
        if (teacher == null){
            throw  new RuntimeException("User not Found");
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setPhone(teacher.getPhone());
        teacherResponse.setPassword(teacher.getPassword());
        return teacherResponse;
    }

    public String removeTeacher(Long id){
        int isRemove = teacherRepo.removeTeacher(id);
        if (isRemove==1){
            return "Teacher Remove SuccessFully";
        }
        return "Teacher does not exist";
    }

}
