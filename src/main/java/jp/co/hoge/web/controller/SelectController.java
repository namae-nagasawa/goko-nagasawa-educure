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
	public String select(@ModelAttribute("select") UserForm form, Model model, HttpSession session) {

		return "select";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectNameTel(@ModelAttribute("select") UserForm form, Model model, HttpServletRequest request,HttpSession session) {

		String userName = form.getUserName();
		String tel1 = form.getTel1();
		

		List<User> resultList = null;
		//resultList = userService.selectNameTel(form);

		if ((userName == null || userName.isEmpty()) && (tel1 == null || tel1.isEmpty())) {
			
			resultList=userService.selectAll();

		} else if (tel1 == null || tel1.isEmpty()) {

			resultList = userService.selectName(form);

		} else if (userName == null || userName.isEmpty()) {

			resultList=userService.selectTel(form);
			
		} else {
			
			resultList = userService.selectNameTel(form);
		}

		
		
		if (resultList != null && !resultList.isEmpty()) {
			  for (User user : resultList) {
			//User user = resultList.get(0);

			
			model.addAttribute("resultList", resultList);
			model.addAttribute("login_id", user.getLoginId());
			model.addAttribute("telephone", user.getTelephone());
			model.addAttribute("role_name", user.getRoleName());
			request.setAttribute("user_name",user.getUserName());
			//session.setAttribute("user_name", user.getUserName());
			//model.addAttribute("user_name", user.getUserName());
			  }
		} else {

			model.addAttribute("msg4", "入力されたデータはありません");
			return "select";
		}
		return "selectResult";

	}
}
