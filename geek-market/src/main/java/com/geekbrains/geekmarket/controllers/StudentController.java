package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.Student;
import com.geekbrains.geekmarket.repositories.StudentRepository;
import com.geekbrains.geekmarket.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllStudents(Model model, HttpServletRequest httpServletRequest) {
        int maxgrade = studentService.findMAXExamgrade();
        int mingrade = studentService.findMINExamgrade();
        model.addAttribute("maxgrade", maxgrade);
        model.addAttribute("mingrade", mingrade);
        List<Student> students = (List<Student>) studentService.findALL();
        model.addAttribute("students", students);
        return "students-page";

    }
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String getPageStudents(@PathVariable("page") int page, Model model, HttpServletRequest httpServletRequest) {
        int maxgrade = studentService.findMAXExamgrade();
        int mingrade = studentService.findMINExamgrade();
        model.addAttribute("maxgrade", maxgrade);
        model.addAttribute("mingrade", mingrade);
        Pageable pageable = PageRequest.of(page, 5, Sort.by("userName").ascending());
        Page<Student> students =  studentService.findAll(pageable);
        model.addAttribute("students", students);
        return "students-page";

    }
    @RequestMapping(value = "/maxgrade", method = RequestMethod.GET)
    public String getMaxGradeStudents(Model model, HttpServletRequest httpServletRequest) {
        int maxgrade = studentService.findMAXExamgrade();
        int mingrade = studentService.findMINExamgrade();
        model.addAttribute("maxgrade", maxgrade);
        model.addAttribute("mingrade", mingrade);
        List<Student> students = (List<Student>) studentService.findAllByExamgradeInMAX();
        model.addAttribute("students", students);
        return "students-page";

    }
    @RequestMapping(value = "/between", method = RequestMethod.GET)
    public String getBetweenGradeStudents(@RequestParam(value = "start", required = false) int start,
                                      @RequestParam(value = "end", required = false) int end,Model model, HttpServletRequest httpServletRequest) {
        int maxgrade = studentService.findMAXExamgrade();
        int mingrade = studentService.findMINExamgrade();
        model.addAttribute("maxgrade", maxgrade);
        model.addAttribute("mingrade", mingrade);
        List<Student> students = (List<Student>) studentService.findAllByExamgradeBetween(start, end);
        model.addAttribute("students", students);
        return "students-page";

    }


}
