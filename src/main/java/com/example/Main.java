package com.example;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Controller
public class Main {
	private List<Movie> movies = new ArrayList<>();
	Client client = new Client();

	public static void main(String[] args) {
		SpringApplication.run(Main.class,args);
	}
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("movies", movies);
		return "index";
	}
	@PostMapping("/generate")
	public String generateDescription(@RequestParam String movieTitle, Model model) {
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please enter the name of a movie");
//		String query = scanner.nextLine();
//		GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", query, null);
//		String description = response.text();
//		movies.add(new Movie(movieTitle, description));
//		model.addAttribute("movies",movies);
//		return "index";
		String query = "Please generate a description of the movie " + movieTitle;
		GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", query, null);
		String description = response.text();
		movies.add(new Movie(movieTitle, description));
		model.addAttribute("movies", movies);
		return "index";
	}


}

//Get Gemini API working
//Get Gemini AI working: set it up without errors- get it to print a greeting like hello to console
//Next get it to to generate a movie description and print it to console- hard code a movie title and print a description to console
//Next with that same movie title description and try to render it with HTML in the controller
//Now add user input to Gemini API prompt
//Next create a form and get the user to enter a movie title and check that you can access user input correctly
//Next add that user input to a prompt "please generate description of the is movie ${movie title}" for Gemini AI to generate
//Save data and display to screen
//Finally save that response and the user input details - most likely to a class called movie and render it to the screen - store all instances of the movie class in a  list in the controller ( but each new run will create a new list which is completely okay and would recommend this route)
//Display your movies and their AI generative descriptions(display the list) - all of them somewhere on your webpage
//Reminder: you might have to review previous Spring modules on how to simply render html in your spring controllers ( don't worry too much about a refined output, just get data to display on your webpage  )
