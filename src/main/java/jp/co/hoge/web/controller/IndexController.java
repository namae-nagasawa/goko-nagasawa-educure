package jp.co.hoge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.loginForm;
import jp.co.hoge.web.entity.User;
@Controller
public class IndexController {


	
	User user =new User();
	
	@RequestMapping("/index")
	public String index(@ModelAttribute("index") loginForm form, Model model) {
		return "index";
	}
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	public String menu(@ModelAttribute("login") loginForm form, Model model) {

		
		return "menu";
	}
}
