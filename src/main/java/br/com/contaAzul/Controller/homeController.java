package br.com.contaAzul.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class homeController {
	@GetMapping({"/","home"})
	public String index() {
		return "home/index";
	}
}
