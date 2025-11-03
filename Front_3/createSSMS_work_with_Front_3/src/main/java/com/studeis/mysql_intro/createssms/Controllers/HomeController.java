package com.studeis.mysql_intro.createssms.Controllers;

import com.studeis.mysql_intro.createssms.entityDB.teacher;
import com.studeis.mysql_intro.createssms.repositories.TeacherRepo;
import jakarta.validation.Valid;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/teacher")
public class HomeController {

    @Autowired
    private TeacherRepo teacherRepository;

    @Autowired
    private Faker faker;

    @GetMapping("/list")
    public String hi(Model model,
                     @RequestParam(defaultValue = "0") int page,
                     @RequestParam(defaultValue = "5") int size) {

        var pageable = org.springframework.data.domain.PageRequest.of(page, size);
        var teacherPage = teacherRepository.findAll(pageable);

        model.addAttribute("title", "Teacher list");
        model.addAttribute("teachers", teacherPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", teacherPage.getTotalPages());

        return "index";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        generationData(10);
        return  "redirect:/api/teacher/list";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        teacherRepository.deleteAll();
        return  "redirect:/api/teacher/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        teacherRepository.deleteById(id);
        return "redirect:/api/teacher/list";
    }

    @ResponseBody
    @DeleteMapping("/path/delete/{id}")
    public String deleteByIdAjax(@PathVariable Long id) {
       teacher teacher = teacherRepository.getById(id);
       teacherRepository.delete(teacher);
        return "Teacher deleted - " + teacher;
    }

    @GetMapping("/edit/{id}")
    public String editByIdAjax(Model model, @PathVariable Long id) {
       teacher teacher = teacherRepository.findById(id).orElse(null);
        model.addAttribute("teacher",  teacher);
        return "update";
    }

    @PostMapping("/update")
    public String updateById(Model model, teacher teacher) {
        teacherRepository.save(teacher);
        model.addAttribute("teacher",  teacher);
        return "redirect:/api/teacher/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Add Teacher");
        model.addAttribute("teacher",  new teacher());
        return "create";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid teacher teacher, BindingResult result) {
        result.getAllErrors();
        if (result.hasErrors()) {
            model.addAttribute("error", "Add Teacher");
            model.addAttribute("teacher",  teacher);
            return "create";
        }else{
        teacherRepository.save(teacher);
        return "redirect:/api/teacher/list";
        }

    }

    private void generationData(int size) {

        if (teacherRepository.count() == 0) {
            List<teacher> people = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                Integer age = faker.number().numberBetween(18,90);
//                people.add(new teacher(name, surname, age));

                teacher teacher = new teacher(name, surname, age);
                teacher.setEmploymentData(LocalDate.now());
                teacher.setPosition("Lecturer");
//                Integer numb = faker.number().numberBetween(10000, 210000);
//                teacher.setSalary(numb);
                people.add(teacher);
            }

            teacherRepository.saveAll(people);
        }
    }

    @GetMapping("/api")
    @ResponseBody
    public Map<String, Object> getTeacherJson(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        var pageable = org.springframework.data.domain.PageRequest.of(page, size);
        var teacherPage = teacherRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("teachers", teacherPage.getContent());
        response.put("currentPage", page);
        response.put("totalPages", teacherPage.getTotalPages());

        return response;
    }
}
