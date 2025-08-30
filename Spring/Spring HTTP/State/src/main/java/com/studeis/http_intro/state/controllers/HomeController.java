package com.studeis.http_intro.state.controllers;

import com.studeis.http_intro.state.models.Movie;
import com.studeis.http_intro.state.models.MovieApiResponse;
import com.studeis.http_intro.state.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class HomeController {
    private List<Person> people;
    private Long counter = 1L;

    public HomeController() {
        people = new ArrayList<>();
        people.add(new Person("Roman", "S", "s@gamil.com", 20, counter++));
        people.add(new Person("Kamilla", "H", "H@gmail.com", 20, counter++));
        people.add(new Person("David", "M", "M@gmail.com", 20, counter++));
    }

//    String baseUrl = "http://www.omdbapi.com/";
//    String apiKey = "266b43cd";
String baseUrl = "http://www.omdbapi.com/";
    String apikey = "266b43cd";

    @GetMapping("/search/{title}")
    public ResponseEntity<?> getMovie(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?s="+ title +"&apiKey=" + apikey + "&page=";


        ResponseEntity<MovieApiResponse> response = restTemplate.getForEntity(url+1, MovieApiResponse.class);
        System.out.println("Send # 1");

        List<Movie> movies = new ArrayList<>();
        if (response.getStatusCode().is2xxSuccessful()) {
            MovieApiResponse result = response.getBody();
            movies.addAll(result.search);

            int totalresult = Integer.parseInt(result.totalResults);
            int pages = (int) Math.ceil(totalresult / 10);

            for (int i = 2; i <= pages; i++) {
                System.out.println("Send # 2" + i);
                response = restTemplate.getForEntity(url+i, MovieApiResponse.class);
            }

            result.search = movies;
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.notFound().build();
        }

//        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//        System.out.println(response);
//       return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAll(){
        if (people.isEmpty()) return  ResponseEntity.noContent().build();

        return ResponseEntity.ok(people);
    }

    @PostMapping("/")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        if(person.getAge() < 18){
            return ResponseEntity.badRequest().build();
        }else {
            people.add(person);
            return new ResponseEntity(person, HttpStatus.CREATED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getByID(@PathVariable Long id){
        Optional <Person> person = people.stream().filter(p -> p.getId().equals(id)).findFirst();
        if(person.isPresent()){
            return ResponseEntity.ok(person.get());
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deleteByID(@PathVariable Long id){
       Optional <Person> p = people.stream().filter(p1 -> p1.getId().equals(id)).findFirst();
        if(p.isPresent()){
            return ResponseEntity.ok(p.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updateById(@PathVariable int id,@RequestBody Person person){
        Optional<Person> result = people.stream().filter(x->x.getId() == id).findFirst();

        if (result.isPresent()){
            Person p = result.get();

            if (person.getAge()!=0){
                p.setAge(person.getAge());
            }
            if (person.getLastName()!=null){
                p.setLastName(person.getLastName());
            }
            if (person.getFirstName()!=null){
                p.setFirstName(person.getFirstName());
            }

            return ResponseEntity.ok(p);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searching/{title}")
    public ResponseEntity<?> getMovie(
            @PathVariable String title,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(defaultValue = "1") int limit
    ) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?s=" + title + "&apiKey=" + apikey + "&page=";

        List<Movie> movies = new ArrayList<>();
        ResponseEntity<MovieApiResponse> response;

        response = restTemplate.getForEntity(url + 1, MovieApiResponse.class);
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            return ResponseEntity.notFound().build();
        }

        MovieApiResponse firstResult = response.getBody();
        int totalResults = Integer.parseInt(firstResult.totalResults);
        int totalPages = (int) Math.ceil(totalResults / 10.0);

        int startPage = skip + 1;
        int endPage = Math.min(startPage + limit - 1, totalPages);

        for (int i = startPage; i <= endPage; i++) {
            ResponseEntity<MovieApiResponse> pageResponse = restTemplate.getForEntity(url + i, MovieApiResponse.class);
            if (pageResponse.getStatusCode().is2xxSuccessful() && pageResponse.getBody() != null) {
                movies.addAll(pageResponse.getBody().search);
            }
        }

        return ResponseEntity.ok(movies);
    }
}


// 100 - 199 -> Information
// 200 - 299 -> True
// 300 - 399 -> Redirect
// 400 - 499 -> False(User)
// 500 - 599 -> False(Server)