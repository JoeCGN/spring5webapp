package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRespository;

@Controller
public class AuthorController {

	private final AuthorRespository authorRespository;
	
	public AuthorController(AuthorRespository authorRespository) {
		super();
		this.authorRespository = authorRespository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRespository.findAll());
		//Look for the template book inside of books
		return "authors";
	}
	
	
	
}
