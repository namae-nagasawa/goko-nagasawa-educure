package jp.co.hoge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.UserForm;
@Controller
public class InsertController {

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("insert") UserForm form, Model model) {
		model.addAttribute("msg3", "登録情報を入力してください");
		return "insert";
	}
	
}
