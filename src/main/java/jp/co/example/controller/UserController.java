package jp.co.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.entity.Modelentity;
import jp.co.example.service.UserService;

@Controller
public class UserController {
	
	
	@RequestMapping(value="/index",params ="param1",method=RequestMethod.POST)
	public List<Modelentity> search1(Model model) {
		UserService userService =new UserService();
		List<Modelentity> resultList =userService.searchAll();
		model.addAttribute("resultList",resultList);
		return resultList;
	}

}
