package jp.co.hoge.web.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.UserForm;
@Controller
public class InsertController {

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("insert") UserForm form, Model model,HttpSession session) {
		session.setAttribute("msg3", "登録情報を入力してください");
		session.setAttribute("msg5","※は必須です。");
		return "insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertDate(@Validated @ModelAttribute("insert") UserForm form,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "insert";
		}
		
		return "insertConfirm";
	}
	
	@RequestMapping(value="/insertConfir",method=RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("insertConfirｍ") UserForm form, Model model) {
		//登録のメソッド
		return "insertConfirm";
	}
}
