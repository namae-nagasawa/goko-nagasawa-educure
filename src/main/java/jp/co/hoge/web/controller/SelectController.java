package jp.co.hoge.web.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.hoge.web.controller.form.UserForm;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.UserService;

@Controller
public class SelectController {
	@Autowired
	private UserService userService;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(@ModelAttribute("select") UserForm form, Model model) {

		return "select";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectNameTel(@ModelAttribute("select") UserForm form, Model model, HttpServletRequest request,
			HttpSession session) {

		String userName = form.getUserName();
		String tel1 = form.getTelephone();

		List<User> resultList;
		

		if ((userName == null || userName.isEmpty()) && (tel1 == null || tel1.isEmpty())) {

			resultList = userService.selectAll();

		} else if (tel1 == null || tel1.isEmpty()) {

			resultList = userService.selectName(form);

		} else if (userName == null || userName.isEmpty()) {

			resultList = userService.selectTel(form);

		} else {

			resultList = userService.selectNameTel(form);
		}

		if (resultList != null && !resultList.isEmpty()) {
			model.addAttribute("resultList", resultList);
		}

		else {
			request.setAttribute("msg4", "入力されたデータはありません");
			return "select";
			
		}
		
		return "selectResult";

	}
}
