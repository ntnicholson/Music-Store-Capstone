package com.capstone.controller.admin;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.entity.Genre;
import com.capstone.service.GenreService;

@RestController
@RequestMapping("/admin/genre")
public class AdminProductController {
	
	@Autowired
	GenreService genreService;
	
	@Autowired
	EntityManager em;
	
	//Display
	@GetMapping("/manage")
	public ModelAndView displayAll() {
		ModelAndView mav = new ModelAndView("ManageGenre", "genreList", genreService.findAll());
		
		return mav;
	}
	@PostMapping(value="/manage")
	public String displayTask(@PathParam("id") String id, @RequestParam("manage") String redirect, RedirectAttributes forward) 
	{

		if (redirect.equals("Delete")) {
			forward.addAttribute("id", id);
			return "redirect:/task/delete/{id}";
		}
		else {
			forward.addAttribute("id", id);
			return "redirect:/task/update/{id}";
		}
	}
	
	//Create
	@GetMapping(value="/create")
	public ModelAndView createGenre() 
	{
		Genre g = new Genre();
		return new ModelAndView("CreateGenre", "newGenre", g);
	}
	@PostMapping(value="/create") @Transactional
	public void saveTask(@Valid @ModelAttribute("newGenre") Genre g, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException
	{
		genreService.save(g);
		response.sendRedirect("/admin/genre/manage");
	}
	
	//Delete
	@GetMapping(value="/delete/{id}") 
	public ModelAndView deleteTask(@PathVariable("id") Long id) 
	{
		Genre g = genreService.findByID(id);
		return new ModelAndView("DeleteGenre", "genre", g);
	}
	@PostMapping(value="/delete/{id}") @Transactional
	public void delete(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		
		genreService.delete(id);
		response.sendRedirect("/admin/genre/manage");
	}
	
	@GetMapping(value="/update/{id}")
	public ModelAndView updateTask(@PathVariable("id") Long id) 
	{
		Genre g = genreService.findByID(id);
		return new ModelAndView("UpdateGenre", "genre", g);
	}
	@PostMapping(value="/update/{id}") @Transactional
	public void updateTask(@Valid @ModelAttribute("newGenre") Genre g, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException {
		
		//taskService.saveTask(t);
		em.merge(g);
		response.sendRedirect("/admin/genre/manage");
	}
}
