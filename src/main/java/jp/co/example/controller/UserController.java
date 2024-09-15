package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.TestForm;
import jp.co.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(@ModelAttribute("index") TestForm form,Model model) {
		model.addAttribute("msg", "検索または登録情報を入力してください");

		return "top";
	}
	
	//mothod

}
