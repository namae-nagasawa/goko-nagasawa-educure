package jp.co.hoge.web.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.UserForm;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.UserService;


@Controller

public class AuthController {

	@Autowired
	private UserService userService;
	@Autowired
	HttpSession session;
	

	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("login") UserForm form, Model model) {
		return "login";
	}
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(@ModelAttribute("logout") UserForm form, Model model) {
		return "logout";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginIdName(@Validated @ModelAttribute("login") UserForm form,BindingResult bindingResult, Model model,HttpSession session) {
		List<User> resultList =new ArrayList<>();
		resultList=userService.loginIdName(form);

		if (bindingResult.hasErrors()) {
			return "login";
		}
		if(resultList.isEmpty()) {
			model.addAttribute("msg", "IDまたはPASSが違います");
			return "login";
		}
		if(!resultList.isEmpty()) {
			resultList=userService.loginIdName(form);
			
		
			User user= resultList.get(0);
			
			
			
			model.addAttribute("resultList", resultList);
			session.setAttribute("role_id",user.getRoleId());
			session.setAttribute("user_name",user.getUserName());
			
			
		}
		
		return "menu";
	}
}