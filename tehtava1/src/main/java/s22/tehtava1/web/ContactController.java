package s22.tehtava1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {
	
	@RequestMapping("contact")
	@ResponseBody
	public String say() {
		return "This is the contact page ";
	}	
}
