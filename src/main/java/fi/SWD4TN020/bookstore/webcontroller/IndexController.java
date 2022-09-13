package fi.SWD4TN020.bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// ei @ResponseBody-annotaatiota
public class IndexController {

	@RequestMapping("/index")
	public String sayGreetings() {
		return "index";
	}

}