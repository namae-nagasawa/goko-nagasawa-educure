package jp.co.hoge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.loginForm;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(@ModelAttribute("index") loginForm form) {
		return "index";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(@ModelAttribute("menu") loginForm form) {

		return "menu";
	}
}
