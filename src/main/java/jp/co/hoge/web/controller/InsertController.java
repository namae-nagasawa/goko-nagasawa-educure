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
public class InsertController {

	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("insert") UserForm form, Model model, HttpSession session,
			HttpSession request) {

		session.setAttribute("msg3", "登録情報を入力してください");
		session.setAttribute("msg5", "※は必須です。");
		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertDate(@Validated @ModelAttribute("insert") UserForm form, BindingResult bindingResult,
			Model model, HttpSession session, HttpSession request) {
		List<User> resultList2 = new ArrayList<>();
		
		resultList2 = userService.selectId(form);
		
		
			if (!resultList2.isEmpty()) {
			model.addAttribute("msg6", "IDが重複しています");
			return "insert";
		}

		if (bindingResult.hasErrors()) {
			return "insert";
		}
//		String posi=null;
//		if(form.getRoleId()==1) {
//			 session.setAttribute("posi","管理者");
//		}else {
//			session.setAttribute("posi","一般");
//		}
		

		if(form.getRoleId()==1) {
			session.setAttribute("posi","管理者");
		}else {
			session.setAttribute("posi","一般");
		}
		//model.addAttribute("resultList2",resultList2);
	
		model.addAttribute("loginId", form.getLoginId());
		model.addAttribute("userName", form.getName());
		model.addAttribute("telephone", form.getTelephone());
		model.addAttribute("roleId", form.getRoleId());//管理者か一般が送られてきているのにIntegerのRoleIdをmodelで扱おうとしているから？
		model.addAttribute("password", form.getPassword());
		

		return "insertConfirm";

	}

	@RequestMapping(value = "/insertConfirm", method = RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("insertConfirm") UserForm form, Model model) {
		if (form.getRePass() == null || !form.getRePass().equals(form.getRePass())) {
			model.addAttribute("msg9", "前画面で入力したパスワードと一致しません");
			return "insertConfirm";
		}
		userService.insert(form);
		model.addAttribute("msg8", "登録が完了しました");
		return "insertResult";
	}

}
