package s22.Listaanlisays.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s22.Listaanlisays.domain.Friend;

@Controller
public class IndexController {
	
	private ArrayList<Friend> friends = new ArrayList<>();
	
	@GetMapping("/index")
	public String showFriends(Model model) {
		model.addAttribute("friendList", friends);
		return "friend";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String friendSubmit(@ModelAttribute Friend fname, Friend lname, Model model) {
		model.addAttribute("friend", fname);
		model.addAttribute("friend", lname);
		return "redirect:/result";
	}
}