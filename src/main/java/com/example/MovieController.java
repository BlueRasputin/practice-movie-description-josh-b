//package com.example;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/movies")
//public class MovieController {
//    private final MovieRepository movieRepository;
//    public MovieController(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//
//    @GetMapping("/all")
//    public List<Main> getAllMovies() {
//        return movieRepository.findAll();
//    }
//    @GetMapping("/{id}")
//    public Optional<Main> getMovie(@PathVariable int id) {
//        return movieRepository.findById(id);
//    }
//    @PostMapping("/add")
//    public Main addItem(@RequestBody Main movie) {
//        return movieRepository.save(movie);
//    }
//    @PutMapping("/{id}")
//    public Main updateItem(@PathVariable int id, @RequestBody Main movie) {
//        return movieRepository.save(movie);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteItem(@PathVariable int id) {
//        movieRepository.deleteById(id);
//    }
//}
