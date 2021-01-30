package com.capstone.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.entity.Category;
import com.capstone.entity.Genre;
import com.capstone.entity.Category;
import com.capstone.service.CategoryService;
import com.capstone.service.GenreService;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {
	
	@Autowired
	GenreService genreService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	EntityManager em;
	
	//Display
	@GetMapping("/manage")
	public ModelAndView displayAll() {
		ModelAndView mav = new ModelAndView("ManageCategory", "categoryList", categoryService.findAll());
		
		return mav;
	}
	//Create
	@GetMapping(value="/create")
	public ModelAndView createCategory(ModelMap m) 
	{
		Category c = new Category();
		List<Genre> genreList = genreService.findAll();
		m.addAttribute("newCategory", c);
		m.addAttribute("genreList", genreList);
		return new ModelAndView("CreateCategory", "newCategory", m);
	}
	@PostMapping(value="/create") @Transactional
	public void saveCategory(@Valid @ModelAttribute("newCategory") Category c, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException
	{
		System.out.println(c.getGenre().getId());
		categoryService.save(c);
		response.sendRedirect("/admin/category/manage");
	}
	
	//Delete
	@GetMapping(value="/delete/{id}") 
	public ModelAndView deleteCategory(@PathVariable("id") Long id) 
	{
		Category g = categoryService.findByID(id);
		return new ModelAndView("DeleteCategory", "category", g);
	}
	@PostMapping(value="/delete/{id}") @Transactional
	public void delete(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		
		categoryService.delete(id);
		response.sendRedirect("/admin/category/manage");
	}
	
	@GetMapping(value="/update/{id}")
	public ModelAndView updateCategory(@PathVariable("id") Long id) 
	{
		Category g = categoryService.findByID(id);
		return new ModelAndView("UpdateCategory", "category", g);
	}
	@PostMapping(value="/update/{id}") @Transactional
	public void updateCategory(@Valid @ModelAttribute("newCategory") Category g, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException {
		
		//taskService.saveCategory(t);
		em.merge(g);
		response.sendRedirect("/admin/category/manage");
	}
}
