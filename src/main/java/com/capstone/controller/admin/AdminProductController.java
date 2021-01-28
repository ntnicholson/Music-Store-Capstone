package com.capstone.controller.admin;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.entity.Product;
import com.capstone.service.ProductService;

@RestController
@RequestMapping("/admin/product")
public class AdminProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	EntityManager em;
	
	//Display
	@GetMapping("/manage")
	public ModelAndView displayAll() {
		ModelAndView mav = new ModelAndView("ManageProduct", "productList", productService.findAll());
		
		return mav;
	}
	
	//Create
	@GetMapping(value="/create")
	public ModelAndView createProduct() 
	{
		Product p = new Product();
		return new ModelAndView("CreateProduct", "newProduct", p);
	}
	@PostMapping(value="/create") @Transactional
	public void saveProduct(@Valid @ModelAttribute("newProduct") Product p, BindingResult bindingResult, 
			Model model, HttpServletResponse response, @RequestParam("image") MultipartFile f) throws IOException
	{
		byte[] picInBytes = new byte[(int) f.getBytes().length];
		picInBytes = f.getBytes();
		p.setImage(picInBytes);
		byte[] encodeBase64 = Base64.encodeBase64(picInBytes); //https://stackoverflow.com/questions/34560229/convert-byte-to-image-and-display-on-jsp
        String base64Encoded = new String(encodeBase64, "UTF-8");
        p.setBase64Image(base64Encoded);
		
		productService.save(p);
		response.sendRedirect("/admin/product/manage");
	}
	
	//Delete
	@GetMapping(value="/delete/{id}") 
	public ModelAndView deleteTask(@PathVariable("id") Long id) 
	{
		Product g = productService.findByID(id);
		return new ModelAndView("DeleteProduct", "product", g);
	}
	@PostMapping(value="/delete/{id}") @Transactional
	public void delete(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		
		productService.delete(id);
		response.sendRedirect("/admin/product/manage");
	}
	
	@GetMapping(value="/update/{id}")
	public ModelAndView updateTask(@PathVariable("id") Long id) 
	{
		Product g = productService.findByID(id);
		return new ModelAndView("UpdateProduct", "product", g);
	}
	@PostMapping(value="/update/{id}") @Transactional
	public void updateTask(@Valid @ModelAttribute("newProduct") Product g, BindingResult bindingResult, 
			Model model, HttpServletResponse response) throws IOException {
		
		//taskService.saveTask(t);
		em.merge(g);
		response.sendRedirect("/admin/product/manage");
	}
}
