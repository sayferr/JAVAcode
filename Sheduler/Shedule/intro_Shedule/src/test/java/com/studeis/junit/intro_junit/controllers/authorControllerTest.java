package com.studeis.junit.intro_junit.controllers;

/** @SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class authorControllerTest {

    @Autowired
    authorRepository authorRepository;

    @Autowired
    private authorController authorController;

    @Autowired
    private ObjectMapper objectMapper;

    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private Faker faker;

   //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void create_author_valid_data_return_author() throws Exception {
        Author author = new Author();
        author.setEmail(faker.internet().emailAddress());
        author.setFirstName(faker.name().firstName());
        author.setLastName(faker.name().lastName());

        mockMvc.perform(
                post("/api/author").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email" ,is(author.getEmail())))
                .andExpect(jsonPath("$.firstName" ,is(author.getFirstName())))
                .andExpect(jsonPath("$.lastName" ,is(author.getLastName())));

    }

    @Test
    @Order(2)
    public void get_author_existing_id_return_author() throws Exception {
        Author author = new Author();
        author.setEmail(faker.internet().emailAddress());
        author.setFirstName(faker.name().firstName());
        author.setLastName(faker.name().lastName());

        Author result = authorRepository.save(author);
        mockMvc.perform(
                        get("/api/author/get={id}", author.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(result.getEmail())))
                .andExpect(jsonPath("$.firstName", is(result.getFirstName())))
                .andExpect(jsonPath("$.id").value(result.getId()))
                .andExpect(jsonPath("$.lastName", is(result.getLastName())));
    }

    @Test
    @Order(3)
    public void get_author_not_existing_return_authors() throws Exception {
        mockMvc.perform(get("/api/author/get={id}", -100))
                .andExpect(status().isNotFound());
    }

    private void add_100_000_authors(){
        if (authorRepository.count()<100_000){
            List<Author> authors = new ArrayList<>();

            for (int i = 0; i < 100_000; i++) {
                String email = faker.internet().emailAddress();
                String name = faker.name().firstName();
                String surname = faker.name().lastName();

                authors.add(new Author(email, name, surname));
            }

            authorRepository.saveAll(authors);
        }
    }

    @Test
    @Order(6)
    public void get_all_author_not_existing_id_return_author() throws Exception {
        add_100_000_authors();

        mockMvc.perform(get("/api/author"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(100)))); // возвращает статус 404,
        // а не 200 (?)
    }

    @Test
    @Order(7)
    public void get_empty_author_return_not_content() throws Exception {
        authorRepository.deleteAll();

        mockMvc.perform(get("/api/author"))
                .andExpect(status().isNoContent()); // возвращает 200, а не 204 (?)
    }

    @Test
    @Order(4)
    public void delete_author_exists_return_ok() throws Exception {
        Author author = new Author();
        author.setEmail(faker.internet().emailAddress());
        author.setFirstName(faker.name().firstName());
        author.setLastName(faker.name().lastName());

        Author result = authorRepository.save(author);


        mockMvc.perform(
                        delete("/api/author/delete{id}", result.getId()))
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    public void delete_author_not_exists_return_not_found() throws Exception {
        mockMvc.perform(
                delete("/api/author/delete{id}", -1))
                .andExpect(status().isNotFound());
    }
} */
