package org.example.demooo.service;

import lombok.RequiredArgsConstructor;
import org.example.demooo.dao.entity.StudentEntity;
import org.example.demooo.dao.repository.Studentrepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final Studentrepository studentrepository;

    public void createStudent(StudentEntity student){
        studentrepository.save(student);
    }

    public void deleteStudent(Long student){
        studentrepository.deleteById(student);
    }

    public StudentEntity getStudent(Long id){
        return studentrepository.findById(id);

    }

    public Iterable<StudentEntity> getStudents(){
        return studentrepository.findAll();
    }

}
