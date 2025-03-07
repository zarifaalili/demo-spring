package org.example.demooo.controller;


import lombok.RequiredArgsConstructor;
import org.example.demooo.dao.entity.StudentEntity;
import org.example.demooo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentservice;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentEntity student){
    studentservice.createStudent(student);
}


@GetMapping
    public Iterable<StudentEntity> getStudents(){
    return studentservice.getStudents();
}

@GetMapping("/{id}")

    public StudentEntity getStudent(@PathVariable Long id){
    return studentservice.getStudent(id);
}

@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
    studentservice.deleteStudent(id);
}

}
