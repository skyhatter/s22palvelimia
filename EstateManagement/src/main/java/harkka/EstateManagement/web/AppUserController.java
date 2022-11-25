package harkka.EstateManagement.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import harkka.EstateManagement.domain.AppUser;
import harkka.EstateManagement.domain.AppUserRegistration;
import harkka.EstateManagement.domain.AppUserRepository;

@Controller
public class AppUserController {
	
	private static final Logger log = LoggerFactory.getLogger(AppUserController.class);
	
	@Autowired
	AppUserRepository auRepository;
	
	@GetMapping("/register")
	public String addAppUser(Model model) {
		log.info("new user template " + new AppUserRegistration());
		model.addAttribute("newuser", new AppUserRegistration());
		return "registration";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@Valid @ModelAttribute("newuser") AppUserRegistration newUser, BindingResult bindingResult) {
		log.info("saveuser: newAppUser is " + newUser.toString());
		if (!bindingResult.hasErrors()) { // validation errors
			if (newUser.getPassword().equals(newUser.getPasswordCheck())) { // check password match
				String pwd = newUser.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				AppUser newAppUser = new AppUser();
				newAppUser.setPasswordHash(hashPwd);
				newAppUser.setUsername(newUser.getUsername());
				newAppUser.setRole("USER");
				if (auRepository.findByUsername(newUser.getUsername()) == null) { // Check if user exists
					auRepository.save(newAppUser);
				} else {
					log.info("username already exists");
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "registration";
				}
			} else {
				log.info("Password doesn't match");
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
				return "registration";
			}
		} else {
			return "registration";
		}
		return "redirect:/login";
	}

}