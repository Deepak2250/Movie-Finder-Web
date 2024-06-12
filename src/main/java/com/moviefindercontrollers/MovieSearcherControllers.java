package com.moviefindercontrollers;

import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.JsonObject;
import com.moviefindercontrollers.model.MovieFinderLoginUserPojo;
import com.moviefindercontrollers.model.MovieFinderUser;
import com.moviefindercontrollers.model.MovieFinderUserImp;
import com.moviefindercontrollers.model.MovieFinderUserPojo;
import com.moviefindercontrollers.service.ApiService;
import com.moviefindercontrollers.service.MovieDetails;
import com.moviefindercontrollers.service.MovieFinderService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class MovieSearcherControllers {

	/// Dependencies

	@Autowired
	private MovieFinderService finderService;
	@Autowired
	MovieFinderUserImp finderUserImp;

	@Autowired
	private ApiService apiService;

	/// register page///

	@GetMapping("/register")
	public String Login(Model model) {
		model.addAttribute("finderUserPojo", new MovieFinderUserPojo());
		return "register";
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("finderUserPojo") MovieFinderUserPojo finderUserPojo,
			BindingResult bindingResult, HttpSession httpSession, Model model,
			@RequestParam("file") MultipartFile file) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			return "register";
		}

		try {
			String email = finderUserPojo.getEmail();

			MovieFinderUser existingUser = finderUserImp.findByEmail(email);
			

			if (existingUser != null && existingUser.getPassword().equals(finderUserPojo.getPassword())) {
				return "registeredusers";
			}
			
			
			
            
			MovieFinderUser finderUser = new MovieFinderUser(finderUserPojo.getName(), finderUserPojo.getEmail(),
					finderUserPojo.getPassword(), finderUserPojo.getFavouriteMovie(),
					finderUserPojo.getFavouriteGenre(), file.getBytes());
			
			

			if (!file.isEmpty()) {
				httpSession.setAttribute("User", finderUser);
				finderService.addUser(finderUser);

				// store the bytes somewhere
				return "userregistered";

			} else {
				return "register";
			}

		}
	catch(Exception e)
	{
		e.printStackTrace();
		return "register";
	}
}


	/// Login Page /////

	@GetMapping("/login")
	public String loginPage(Model model, HttpSession session) {
		boolean registerFirst = session.getAttribute("registerFirst") != null;
		model.addAttribute("registerFirst", registerFirst);
		model.addAttribute("movieFinderLoginUserPojo", new MovieFinderLoginUserPojo());
		return "login";
	}

	@PostMapping("/loggedIn")
	public String loggedInUser(
			@Valid @ModelAttribute("movieFinderLoginUserPojo") MovieFinderLoginUserPojo movieFinderLoginUserPojo,
			BindingResult bindingResult, HttpSession httpSession, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			return "login";
		}

		try {
			String email = movieFinderLoginUserPojo.getEmail();

			MovieFinderUser existingUser = finderUserImp.findByEmail(email);

			if (existingUser != null && existingUser.getPassword().equals(movieFinderLoginUserPojo.getPassword())) {
				httpSession.setAttribute("isLoggedIn", true);
				
				byte[] image = existingUser.getImage();
				
				String base64EncodedImage = Base64.getEncoder().encodeToString(image);
				System.out.println(base64EncodedImage);
				httpSession.setAttribute("image", base64EncodedImage);
				httpSession.setAttribute("email", email);

				System.out.println("The Email and Password is Correct ");
				
				return "redirect:/home"; // Redirecting to the home page
			}

			else {
				httpSession.setAttribute("registerFirst", true);
				return "login";
			}
		} catch (EmptyResultDataAccessException e) {
			httpSession.setAttribute("registerFirst", true);
			e.getMessage();
			return "login";
		}
	}

	//// Home Page ////

	@GetMapping("/")
	public String HomePage(Model model, HttpSession session) {
		boolean isLoggedIn = session.getAttribute("isLoggedIn") != null ? true : false;
		model.addAttribute("isLoggedIn", isLoggedIn);
		return "home";
	}

	@GetMapping("/home")
	public String HomePage2(Model model, HttpSession session) {
		boolean isLoggedIn = session.getAttribute("isLoggedIn") != null ? true : false;
		model.addAttribute("isLoggedIn", isLoggedIn);
		return "home";
	}

	/// movie page /////

	@GetMapping("/moviepage")
	public String MovieSearchPage() {
		return "moviesearch";
	}

	/// Searching The Movie

	@PostMapping("/moviesearch")
	public String MovieSearchResult(@RequestParam("movieName") String movieName, Model model, HttpSession session) {
		MovieDetails movieDetails = apiService.fetchDataFromApi(movieName);
		model.addAttribute(movieDetails);
		session.setAttribute("movieDetails", movieDetails);
		return "moviesearchresult";
	}

	/// About page////

	@GetMapping("/about")
	public String About(Model model, HttpSession httpSession) {
		boolean isLoggedIn = httpSession.getAttribute("isLoggedIn") != null ? true : false;
		model.addAttribute("isLoggedIn", isLoggedIn);
		return "about";
	}

	/// Profile

	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {

		if (session.getAttribute("isLoggedIn") == null) {
			return "redirect:/login";
		}

		String email = (String) session.getAttribute("email");
		MovieFinderUser userInfo = finderUserImp.findByEmail(email);
		String image = (String) session.getAttribute("image");
		
		session.setAttribute("image", image);
		session.setAttribute("userInfo", userInfo);
		model.addAttribute(userInfo);
		model.addAttribute("image", image);

		return "profile";

	}

}
