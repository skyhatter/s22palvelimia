package s22.tehtava2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("hello")
	@ResponseBody
	public String sayHello(@RequestParam(name= "location") String location,
			@RequestParam(name="name") String nimi) {
		return "Welcome to the  " + location + " " + nimi + "!";
	}
	
}