package com.capstone.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.Category;

public class AdminCategoryController {

	//CRUD categories
	//Display Categories
	@GetMapping(value="/show/categories")
	public ModelAndView displayCategories() 
	{
		List<Category> display = new ArrayList<Category>();
		//display = taskService.findAll();
		
		return new ModelAndView("DisplayTasks", "taskList", display);
	}
}
