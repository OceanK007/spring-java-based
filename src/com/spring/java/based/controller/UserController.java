package com.spring.java.based.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.java.based.model.User;
import com.spring.java.based.service.UserService;

@Controller
public class UserController 
{
	@Autowired					// This is the annotation for autowiring
	UserService userService;	
	
	@RequestMapping(value="/")
	public ModelAndView homePage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		mav.addObject("userModel", userService.getUserData());
		
		return mav;
	}
	
	/*@RequestMapping(value="/")
	public String homePage(Model model)
	{
		User u = new User();
		u.setName("Ocean");
	
		model.addAttribute("userModel", u);
		
		return "home";
	}*/
	
	/*@RequestMapping(value="/")
	public String homePage(ModelMap modelMap)
	{
		User u = new User();
		u.setName("Ocean");
	
		modelMap.addAttribute("userModel", u);
		
		return "home";
	}*/
}
