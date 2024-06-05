package com.moviefindercontrollers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.moviefindercontrollers.database.MovieFinderService;
import com.moviefindercontrollers.database.MovieFinderUser;
import com.moviefindercontrollers.database.MovieFinderUserImp;
import com.moviefindercontrollers.database.MovieFinderUserPojo;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class MovieSearcherControllers {

	
	@Autowired
	private MovieFinderService finderService;
	@Autowired MovieFinderUserImp finderUserImp;

	
	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("finderUserPojo", new MovieFinderUserPojo());
		return "register";
	}
	
	@PostMapping("/registration")
	public String registration( @Valid @ModelAttribute("finderUserPojo") MovieFinderUserPojo finderUserPojo , BindingResult bindingResult  ,  HttpSession httpSession , Model model) {
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			return "register";
		}
		
		try {
	    String email = finderUserPojo.getEmail();
		
		 MovieFinderUser existingUser = finderUserImp.findByEmail(email);
		 
		 if(existingUser!=null && existingUser.getPassword().equals(finderUserPojo.getPassword())) {
			 httpSession.setAttribute("isLoggedIn", true); 
			 return"registeredusers";
		 }
		}
		catch (EmptyResultDataAccessException e ) {
			e.getMessage();
		}
	    
		MovieFinderUser  finderUser = new MovieFinderUser(finderUserPojo.getName() , finderUserPojo.getEmail() , finderUserPojo.getPassword());
		httpSession.setAttribute("User", finderUser);
		finderService.addUser(finderUser);
		return "userregistered" ;
	}
	
	@GetMapping("/")
	public String HomePage(Model model , HttpSession session) {
		 boolean isLoggedIn = session.getAttribute("isLoggedIn") != null ? true : false;
	        model.addAttribute("isLoggedIn", isLoggedIn);
		return "home";
	}
	@GetMapping("/home")
	public String HomePage2(Model model , HttpSession session) {
		 boolean isLoggedIn = session.getAttribute("isLoggedIn") != null ? true : false;
	        model.addAttribute("isLoggedIn", isLoggedIn);
		return "home";
	}
	
	@GetMapping("/moviepage")
	public String MovieSearchPage() {
		return "moviesearch";
	}
	@GetMapping("/about")
	public String About(Model model , HttpSession httpSession) {
		boolean isLoggedIn = httpSession.getAttribute("isLoggedIn") !=null ? true : false;
		model.addAttribute("isLoggedIn", isLoggedIn);
		return "about";
	}
	
}
