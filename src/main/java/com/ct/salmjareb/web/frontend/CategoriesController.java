package com.ct.salmjareb.web.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ct.salmjareb.domain.Category;
import com.ct.salmjareb.service.CategoryService;


@Controller
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private CategoryService categoryService;
	
	private static final Integer LIMIT = 10;
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String categoriesListing(Model model, @RequestParam(value="page", required = false, defaultValue = "1") Integer page){
		
		Integer start = page * LIMIT - LIMIT;
		List<Category> categories = categoryService.getAll(start, LIMIT);
		
		model.addAttribute("categories", categories);
		
		return "categoriesListing";
	}

}
