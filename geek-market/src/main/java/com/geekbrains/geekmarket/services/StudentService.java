package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Student;
import com.geekbrains.geekmarket.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this. studentRepository = studentRepository ;
    }
    public List<Student> findAllByExamgradeBetween(int min, int max) {
        return studentRepository.findAllByExamgradeBetween(min,max);
    }


    public List<Student>findAllByExamgradeInMAX () {
        return studentRepository.findAllByExamgradeInMAX();
    }

    public int findMAXExamgrade() {
        return studentRepository.findMAXExamgrade();
    }
    public List<Student> findAllByExamgradeInMIN() {
        return studentRepository.findAllByExamgradeInMIN();
    }
    public int findMINExamgrade() {
        return studentRepository.findMINExamgrade();
    }
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    public List<Student> findALL(){
        return (List<Student>) studentRepository.findAll();
    }


}
