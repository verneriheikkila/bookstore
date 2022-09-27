package fi.SWD4TN020.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.SWD4TN020.bookstore.domain.Book;
import fi.SWD4TN020.bookstore.domain.Category;
import fi.SWD4TN020.bookstore.domain.CategoryRepository;

@Controller
public class CategoryListController {
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/categorylist")
		public String categoryList(Model model) {
			model.addAttribute("categories", crepository.findAll());
			return "categorylist";
		}
	// Add Category
	@RequestMapping(value = "/addcategory")
	public String addCategoryk(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category) {
		crepository.save(category);
		return "redirect:categorylist";
	}
	}

