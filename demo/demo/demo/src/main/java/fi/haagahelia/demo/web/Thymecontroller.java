package fi.haagahelia.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class Thymecontroller {
	@RequestMapping("/hello")
	public String hello(Model model) {
		String myName ="gearoid";
		model.addAttribute("name",myName);
		
		return "hello";
	}

}
