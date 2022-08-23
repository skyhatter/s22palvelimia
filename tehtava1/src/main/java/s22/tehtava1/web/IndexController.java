package s22.tehtava1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@RequestMapping("index")
	@ResponseBody
	public String say() {
		return "This is the main page ";
	}	
}