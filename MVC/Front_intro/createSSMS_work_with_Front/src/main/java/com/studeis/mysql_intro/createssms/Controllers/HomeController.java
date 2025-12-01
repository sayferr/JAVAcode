package com.studeis.mysql_intro.createssms.Controllers;

import com.studeis.mysql_intro.createssms.entityDB.teacher;
import com.studeis.mysql_intro.createssms.repositories.TeacherRepo;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

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
//    public String hi(Model model) {
//        model.addAttribute("title","Home Page");
//        model.addAttribute("teachers", teacherRepository.findAll());
//        return  "index";
//    }
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
        return  "redirect:/api/teacher/list";
    }


    //sortirovka
    //on front
    //on  backend (repository , streamApi)


//    @GetMapping("/delete/{id}")
//    public String deleteById(Model model, @PathVariable Long id) {
//        model.addAttribute("title","Home Page");
//        teacherRepository.deleteById(id);
//        model.addAttribute("title","Home Page");
//        model.addAttribute("teachers", teacherRepository.findAll());
//        return  "index";
//    }


//    @GetMapping("/hi")
//    public String hi(Model model) {
////        String str = "Farid Abdullayev";
//        model.addAttribute("title","Home Page");
////        model.addAttribute("sms",str);
////        model.addAttribute("name","Java");
////        model.addAttribute("value",100);
//
////        model.addAttribute("tags",List.of("one","two","three","four","five","six","seven"));
////        model.addAttribute("tags",new String[]{"one","two","three","four","five","six","seven"});
//
////        model.addAttribute("person",new Person("Farid","Abdullayev",29));
////        model.addAttribute("person",new Person("Farid","Abdullayev",29));
//
////        generationData();
//
////        model.addAttribute("people",teacherRepository.findAll());
//
//
////        Map<String,Object> map = new HashMap<>();
////        map.put("name", "Farid");
////        model.addAttribute("people", map);
//
////        model.addAttribute("sms","Hello world!");
//
    ////        model.addAttribute("person",new Person("Farid","Abdullayev",29));
//
//        return  "index";
//    }


    private void generationData(int size) {

        if (teacherRepository.count() == 0) {
            List<teacher> people = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                Integer age = faker.number().numberBetween(18,100);
                people.add(new teacher(name, surname, age));
            }

            teacherRepository.saveAll(people);
        }
    }

}
