//package com.studeis.junit.intro_junit.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.javafaker.Faker;
//import com.studeis.junit.intro_Shedule.controllers.bookController;
//import com.studeis.junit.intro_Shedule.entities.Book;
//import com.studeis.junit.intro_Shedule.repositories.bookRepository;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class bookTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private bookController controller;
//
//    @Autowired
//    private bookRepository bookRepository;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private Faker faker;
//
//    @Test
//    @Order(1)
//    public void create_book_validate_returns_books() throws Exception {
//        Book book = new Book(
//                faker.book().title(),
//                faker.book().author(),
//                faker.book().publisher(),
//                "123456",
//                31.99
//        );
//
//        mockMvc.perform(post("/api/books")
//                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
//                        .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.author", is(book.getAuthor()))) // ?
//                .andExpect(jsonPath("$.title", is(book.getTitle())));
//    }
//
//    @Test
//    @Order(2)
//   public void getBook_existingId_returnsBook() throws Exception {
//        Book book = bookRepository.save(new Book(
//                faker.book().title(),
//                faker.book().author(),
//                faker.book().publisher(),
//                "2010",
//                19.99));
//
//        mockMvc.perform(get("/api/books//get={id}", book.getId()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(book.getId())))
//                .andExpect(jsonPath("$.author", is(book.getAuthor())));     // ?
//    }
//
//    @Test
//    @Order(3)
//    public void getBook_nonExistingId_returns404() throws Exception {
//        mockMvc.perform(get("/api/books//get={id}", 9999))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @Order(4)
//    public void create_book_empty_title_returns_400() throws Exception {
//        Book book = new Book(
//                faker.book().title(),
//                faker.book().author(),
//                faker.book().publisher(),
//                "245",
//                49.99
//        );
//
//        mockMvc.perform(post("/api/books")
//        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
//                .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isBadRequest());       // ?
//    }
//
//    @Test
//    @Order(5)
//    void create_book_invalidIsbn_returns_400() throws Exception {
//        Book book = new Book(faker.book().title(),
//                faker.book().author(),
//                faker.book().publisher(),
//                "2020",
//                10.0
//        );
//
//        mockMvc.perform(post("/api/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @Order(6)
//    void create_book_negativePrice_returns_400() throws Exception {
//        Book book = new Book(faker.book().title(),
//                faker.book().author(),
//                faker.book().publisher(),
//                "2020",
//                5.0
//        );
//
//        mockMvc.perform(post("/api/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @Order(7)
//    void createBook_futureYear_returns400() throws Exception {
//        Book book = new Book(faker.book().title(),
//                faker.book().author(),
//                faker.book().publisher(),
//                "3000",
//                15.0
//        );
//
//        mockMvc.perform(post("/api/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @Order(8)
//    void updateBook_existingId_returnsUpdated() throws Exception {  //400
//        Book saved = new Book(
//                "Olddd",
//                "Abc",
//                "12345678920",
//                "1010",
//                110.0
//        );
//
//        saved.setTitle("Updated Title");
//
//        mockMvc.perform(put("/api/books/{id}", saved.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(saved)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Updated title"));
//    }
//
//    @Test
//    @Order(9)
//    void updateBook_nonExistingId_returns404() throws Exception { //404
//        Book book = new Book(
//                 "New",
//                "Authors",
//                "12890",
//                "1980",
//                120.0
//        );
//
//        mockMvc.perform(put("/api/books/{id}", 9999)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isNotFound());
//    }
//
//
//
//    private void add_1000_books(){
//        if (bookRepository.count()<1000){
//            List<Book> books = new ArrayList<>();
//
//            for (int i = 0; i < 1000; i++) {
//                String title = faker.book().title();
//                String author = faker.book().author();
//                String publisher = faker.book().publisher();
//
//                books.add(new Book(title, author, publisher));
//            }
//
//            bookRepository.saveAll(books);
//        }
//    }
//
//    @Test
//    @Order(10)
//    void searchBooksByTitle_partialMatch() throws Exception {
//        add_1000_books();
//
//        mockMvc.perform(get("/api/books/search")
//                        .param("title", "Spring"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()", is(bookRepository.count())));
//    }
//
//    @Test
//    @Order(11)
//    void get_books_first_page_limit_10() throws Exception {
//        for (int i = 0; i < 30; i++) {
//            bookRepository.save(new Book(faker.book().title(),
//                    faker.book().author(),
//                    "1234567890",
//                    "2015",
//                    (double) i));
//        }
//
//        mockMvc.perform(get("/api/books")
//                        .param("page", "0")
//                        .param("size", "10"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content.length()").value(10));
//    }
//}
