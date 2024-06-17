package com.moviefindercontrollers;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moviefindercontrollers.model.MovieFinderLoginUserPojo;
import com.moviefindercontrollers.model.MovieFinderUser;
import com.moviefindercontrollers.model.MovieFinderUserImp;
import com.moviefindercontrollers.model.MovieFinderUserPojo;
import com.moviefindercontrollers.model.UpdateUserPojo;
import com.moviefindercontrollers.service.ApiService;
import com.moviefindercontrollers.service.MovieDetails;
import com.moviefindercontrollers.service.MovieFinderService;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step;

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

				String base64EncodedImage = Base64.getEncoder().encodeToString(finderUser.getImage());
				httpSession.setAttribute("image", base64EncodedImage);

				return "userregistered";

			} else {
				return "register";
			}

		} catch (Exception e) {
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
		try {
			MovieDetails movieDetails = apiService.fetchDataFromApi(movieName);
			System.out.println(movieDetails);
			if (movieDetails.getName() == "Null") {
				return "errorpage";
			}
			model.addAttribute(movieDetails);
			session.setAttribute("movieDetails", movieDetails);
		} catch (Exception e) {
			return "errorpage";
		}
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
		Long id = finderService.getUserId(email);

		MovieFinderUser userInfo = finderUserImp.findByEmail(email);
		userInfo.setId(id);
		String image = (String) session.getAttribute("image");

		session.setAttribute("image", image);
		session.setAttribute("userInfo", userInfo);
		session.setAttribute("id", id);
		model.addAttribute(userInfo);
		model.addAttribute("image", image);

		return "profile";

	}

	/// Updating Profile

	@GetMapping("/updateProfilePage/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model, HttpSession session) {
		session.setAttribute("id", id);
		model.addAttribute("updateUserPojo", new UpdateUserPojo());
		return "updateUser";
	}

	@PostMapping("/updateProfile")
	public String profileUpdate(@Valid @ModelAttribute("updateUserPojo") UpdateUserPojo updateUserPojo,
			BindingResult result, Model model, HttpSession session, @RequestParam("file") MultipartFile file)
			throws IOException {
		if (result.hasErrors()) {
			return "updateUser"; // Return to the update form if there are validation errors
		}

		Long id = (Long) session.getAttribute("id");
		MovieFinderUser finderUser = new MovieFinderUser(updateUserPojo.getName(), updateUserPojo.getFavouriteMovie(),
				updateUserPojo.getFavouriteGenre(), id, file.getBytes());

		finderService.modifyUser(finderUser);
		return "redirect:/profile"; // Redirect to profile page after successful update
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(HttpSession session) {
		String email = (String) session.getAttribute("email");
		finderService.delete(email);
		session.invalidate();
		return "redirect:/home";
	}
}
